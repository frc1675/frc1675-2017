package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearIntake extends CommandGroup {

	public GearIntake() {

		//addSequential(new GearManipulatorDown());
		addSequential(new GearManipulating(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_IN));
	}
}
