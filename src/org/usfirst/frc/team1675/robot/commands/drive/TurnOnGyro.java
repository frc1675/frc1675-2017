package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnOnGyro extends PIDCommand {
	static final double P = .0093;
	static final double I = .00044;
	static final double D = .005;
	static final int TOLERANCE = 2;
	static final int BUFFER = 10;
	static final int ENDALIGN = 5;
	double setpoint;
	int counter = 0;

	public TurnOnGyro(double setpoint) {
		super(P, I, D);
		requires(Robot.driveBase);
		this.setpoint = setpoint;
	}

	protected void initialize() {
		SmartDashboard.putString("Turn command", "Started");
		Robot.driveBase.resetGyro();
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
		if (counter == ENDALIGN) {
			return true;
		}
		return false;
	}

	protected void end() {
		this.getPIDController().disable();
		SmartDashboard.putString("Turn command", "Ended");
		Robot.driveBase.setLeftMotors(0);
		Robot.driveBase.setRightMotors(0);
	}

	protected void interrupted() {
		end();
	}

	protected double returnPIDInput() {
		return Robot.driveBase.getAngle();
	}

	protected void usePIDOutput(double output) {
		Robot.driveBase.setLeftMotors(-output);
		Robot.driveBase.setRightMotors(output);
	}
}