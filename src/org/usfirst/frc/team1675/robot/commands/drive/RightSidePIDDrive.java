package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RightSidePIDDrive extends PIDCommand {
	double setpoint;
	double timeout;

	/**
	 * 
	 * @param setpoint
	 *            distance to drive in inches
	 */
	public RightSidePIDDrive(double setpoint, double timeout) {
		super(RobotMap.DriveBaseConstants.P, RobotMap.DriveBaseConstants.I, RobotMap.DriveBaseConstants.D);
		// Use requires() here to declare subsystem dependencies
		this.setpoint = setpoint * RobotMap.DriveBaseConstants.TICKS_PER_INCH;
		this.timeout = timeout;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveBase.resetEncoder();
		Robot.driveBase.reverseEncoder(false);
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setSetpoint(setpoint);
        this.getPIDController().setOutputRange(-1.0, 1.0);
        this.setTimeout(timeout);
		this.getPIDController().setAbsoluteTolerance(RobotMap.DriveBaseConstants.TOLERANCE);
		this.getPIDController().setToleranceBuffer(RobotMap.DriveBaseConstants.BUFFER);
		
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if(this.getPIDController().onTarget() || this.isTimedOut()){
			SmartDashboard.putNumber("finalRight", Robot.driveBase.getRightEncoderValue());
			return true;
		}else return false;
	}

	protected void end() {
		this.getPIDController().disable();
		Robot.driveBase.setRightMotors(0);
	}

	protected void interrupted() {
		end();
	}

	protected double returnPIDInput() {
		double encodervalue = Robot.driveBase.getRightEncoderValue();
		return encodervalue;
	}

	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("RightPIDoutput", output);
		SmartDashboard.putNumber("RightPIDError", this.getPIDController().getError());
		SmartDashboard.putNumber("RightPIDEncValue", Robot.driveBase.getRightEncoderValue());
		Robot.driveBase.setRightMotors(output);
	}
}
