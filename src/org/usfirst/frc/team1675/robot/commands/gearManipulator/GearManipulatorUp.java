package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearManipulatorUp extends Command {

	public GearManipulatorUp() {
		requires(Robot.gearManipulator);
		this.setTimeout(RobotMap.GearManipulatorConstants.SOLENOID_ACTIVE_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.gearManipulator.retractGearManipulator();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.gearManipulator.stopSolenoids();
	}

	protected void interrupted() {
		end();
	}
}
