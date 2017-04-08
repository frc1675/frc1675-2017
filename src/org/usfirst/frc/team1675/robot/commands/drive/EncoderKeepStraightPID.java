package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderKeepStraightPID extends PIDCommand {

	private double timeout;

	public EncoderKeepStraightPID(double timeout) {
		super(RobotMap.DriveBaseConstants.P_ENCODER_STRAIGHT, RobotMap.DriveBaseConstants.I_ENCODER_STRAIGHT,
				RobotMap.DriveBaseConstants.D_ENCODER_STRAIGHT);
		this.timeout = timeout;
		requires(Robot.driveBase);
	}

	protected void initialize() {
		Robot.driveBase.resetEncoder();
		Robot.driveBase.reverseEncoder(false);
		Robot.driveBase.setStraight(false);
		Robot.driveBase.setStraightenPIDOutput(0);
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setSetpoint(0);
		this.getPIDController().setOutputRange(-1.0, 1.0);
		this.setTimeout(timeout);
		this.getPIDController().setAbsoluteTolerance(RobotMap.DriveBaseConstants.TOLERANCE_ENCODER_STRAIGHT);
		this.getPIDController().setToleranceBuffer(RobotMap.DriveBaseConstants.BUFFER_ENCODER_STRAIGHT);
	}

	protected void execute() {
		Robot.driveBase.setStraight(this.getPIDController().onTarget());
	}

	protected boolean isFinished() {
		if ((Robot.driveBase.isDistanceOnTarget() && Robot.driveBase.isStraight()) || this.isTimedOut()) {
			SmartDashboard.putNumber("finalEncoderDif", Robot.driveBase.getEncoderValueDifference());
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
		return Robot.driveBase.getEncoderValueDifference();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveBase.setStraightenPIDOutput(output);
	}
}
