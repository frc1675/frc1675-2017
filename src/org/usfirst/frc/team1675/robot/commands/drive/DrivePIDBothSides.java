package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DrivePIDBothSides extends PIDCommand {
	
	private double setpoint;
	private double timeout;

    public DrivePIDBothSides(double setpoint, double timeout) {
    	super(RobotMap.DriveBaseConstants.P_BOTH, RobotMap.DriveBaseConstants.I_BOTH, RobotMap.DriveBaseConstants.D_BOTH);
    	this.setpoint = setpoint * RobotMap.DriveBaseConstants.TICKS_PER_INCH;
		this.timeout = timeout;
    }

    protected void initialize() {
    	Robot.driveBase.resetEncoder();
		Robot.driveBase.reverseEncoder(false);
		Robot.driveBase.setDistanceOnTarget(false);
		Robot.driveBase.setDistancePIDOutput(0);
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setSetpoint(setpoint);
        this.getPIDController().setOutputRange(-1.0, 1.0);
        this.setTimeout(timeout);
		this.getPIDController().setAbsoluteTolerance(RobotMap.DriveBaseConstants.TOLERANCE_BOTH);
		this.getPIDController().setToleranceBuffer(RobotMap.DriveBaseConstants.BUFFER_BOTH);
    }

    protected void execute() {
    	Robot.driveBase.setDistanceOnTarget(this.getPIDController().onTarget());
    }

    protected boolean isFinished() {
    	if((Robot.driveBase.isDistanceOnTarget() && Robot.driveBase.isStraight()) || this.isTimedOut()){
    		SmartDashboard.putNumber("finalLeft", Robot.driveBase.getLeftEncoderValue());
			SmartDashboard.putNumber("finalRight", Robot.driveBase.getRightEncoderValue());
    		return true;
    	}
        return false;
    }

    protected void end() {
    	this.getPIDController().disable();
    	Robot.driveBase.setDistanceOnTarget(false);
    	Robot.driveBase.setDistancePIDOutput(0);
    }

    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return Robot.driveBase.getAverageEncoderValue();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveBase.setDistancePIDOutput(output);
	}
}
