package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearManipulatorDown extends Command {

	public GearManipulatorDown() {
		requires(Robot.gearManipulator);
		this.setTimeout(RobotMap.GearManipulatorConstants.SOLENOID_ACTIVE_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.gearManipulator.deployGearManipulator();
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
