package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoScore extends CommandGroup {

	public AutoScore(double power) {
		
		addSequential(new GearManipulating(power));
		//addSequential(new GearManipulatorDown());
		
	}
}
