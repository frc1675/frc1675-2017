package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheeseDrive extends Command {

	public CheeseDrive() {
		requires(Robot.driveBase);
	}

	protected void initialize() {
	}

	protected void execute() {
		double updown = Robot.oi.getDriverLeftYAxis();
		double leftright = Robot.oi.getDriverRightXAxis();
		Robot.driveBase.setLeftMotors(updown - leftright);
		Robot.driveBase.setRightMotors(updown + leftright);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}