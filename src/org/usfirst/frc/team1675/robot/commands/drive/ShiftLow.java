package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftLow extends Command {

	public ShiftLow() {
		//requires(Robot.driveBase);
		this.setTimeout(RobotMap.DriveBaseConstants.SHIFTER_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveBase.shiftLow();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.driveBase.stopShifter();
	}

	protected void interrupted() {
		end();
	}
}
