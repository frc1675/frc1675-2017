package org.usfirst.frc.team1675.robot.commands.auto;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.DriveForDistance;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.AutoScore;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearCenter extends CommandGroup {

    public GearCenter() {
    	
    	addSequential(new DriveForDistance(78.35, 5.0));
    	addSequential(new AutoScore(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
