package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.RobotMap.DriveBaseConstants;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroKeepStraightPID extends PIDCommand {
	
	private double timeout;

	public GyroKeepStraightPID(double timeout){
		super(RobotMap.DriveBaseConstants.P_GYRO_STRAIGHT, RobotMap.DriveBaseConstants.I_GYRO_STRAIGHT, RobotMap.DriveBaseConstants.D_GYRO_STRAIGHT);
		this.timeout = timeout;
	}
	
	protected void initialize() {
		Robot.driveBase.resetGyro();
		Robot.driveBase.setStraight(false);
		Robot.driveBase.setStraightenPIDOutput(0);
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setSetpoint(0);
        this.getPIDController().setOutputRange(-1.0, 1.0);
        this.setTimeout(timeout);
		this.getPIDController().setAbsoluteTolerance(RobotMap.DriveBaseConstants.TOLERANCE_GYRO_STRAIGHT);
		this.getPIDController().setToleranceBuffer(RobotMap.DriveBaseConstants.BUFFER_GYRO_STRAIGHT);
    }

    protected void execute() {
    	Robot.driveBase.setStraight(this.getPIDController().onTarget());
    }

    protected boolean isFinished() {
    	if((Robot.driveBase.isDistanceOnTarget() && Robot.driveBase.isStraight()) || this.isTimedOut()){
    		SmartDashboard.putNumber("finalAngle", Robot.driveBase.getAngle());
    		return true;
    	}
        return false;
    }

    protected void end() {
    	this.getPIDController().disable();
    	Robot.driveBase.setStraight(false);
    	Robot.driveBase.setStraightenPIDOutput(0);
    }

    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return Robot.driveBase.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveBase.setStraightenPIDOutput(output);
	}
}
