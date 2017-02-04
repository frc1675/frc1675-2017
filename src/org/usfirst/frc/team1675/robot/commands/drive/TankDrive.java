package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.driveBase);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveBase.setLeftMotors(Robot.oi.getDriverLeftYAxis());
		Robot.driveBase.setRightMotors(Robot.oi.getDriverRightYAxis());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.driveBase.setLeftMotors(0);
		Robot.driveBase.setRightMotors(0);
	}

	protected void interrupted() {
		end();
	}
}