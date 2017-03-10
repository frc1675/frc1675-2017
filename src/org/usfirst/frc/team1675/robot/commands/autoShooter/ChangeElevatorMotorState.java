package org.usfirst.frc.team1675.robot.commands.autoShooter;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeElevatorMotorState extends Command {
	boolean shooting;

	public ChangeElevatorMotorState(boolean shooting) {
		this.shooting = shooting;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
			Robot.autoShooter.setShooting(shooting);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
