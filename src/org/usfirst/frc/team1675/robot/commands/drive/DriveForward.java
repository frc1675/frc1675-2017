package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForward extends PIDCommand {
	static final double P = .0093;
	static final double I = .00044;
	static final double D = .005;
	static final int BUFFER = 10;
	static final int COUNTERSETPOINT = 5;
	double setpoint;
	int counter = 0;
	// 720 tick/rotation / 18.85 in/rotation = 38.2 ticks/inch
	private static final double TICKS_PER_INCH = 38.2;

	private static final double TOLERANCE = TICKS_PER_INCH * 2.0;

	public DriveForward(double setpoint) {
		super(P, I, D);
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveBase);
		this.setpoint = setpoint * TICKS_PER_INCH;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveBase.resetEncoder();
		Robot.driveBase.reverseEncoder(false);
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setSetpoint(setpoint);
		this.getPIDController().setAbsoluteTolerance(TOLERANCE);
		this.getPIDController().setToleranceBuffer(BUFFER);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if (this.getPIDController().onTarget()) {
			counter = counter + 1;
		} else {
			counter = 0;
		}
		SmartDashboard.putNumber("Counter", counter);
		if (counter == COUNTERSETPOINT) {
			return true;
		}
		return false;
	}

	protected void end() {
		this.getPIDController().disable();
		Robot.driveBase.setLeftMotors(0);
		Robot.driveBase.setRightMotors(0);
	}

	protected void interrupted() {
		end();
	}

	protected double returnPIDInput() {
		double encodervalue = Robot.driveBase.getEncoderValue();
		return encodervalue;
	}

	protected void usePIDOutput(double output) {
		Robot.driveBase.setLeftMotors(-output);
		Robot.driveBase.setRightMotors(-output);
	}
}
