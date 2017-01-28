package org.usfirst.frc.team1675.robot.commands.auger;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SpinAuger extends Command {

	private double spinPower;

	public SpinAuger(double spinPower) {
		requires(Robot.auger);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.spinPower = spinPower;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.auger.setAugerPower(spinPower);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.auger.setAugerPower(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
