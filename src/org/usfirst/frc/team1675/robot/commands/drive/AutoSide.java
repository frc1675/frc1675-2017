package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.AutoScore;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSide extends CommandGroup {

    public AutoSide() {
        // Add Commands here:
        addSequential(new KidneyGrassDrive(66,7));
        addSequential(new TurnOnGyro(51,7));
        addSequential(new KidneyGrassDrive(77,7));
        addSequential(new AutoScore(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT));
//        addSequential(new SunflowerDrive(66,7));
//        addSequential(new TurnOnGyro(53,7));
//        addSequential(new SunflowerDrive(73,7));
//        addSequential(new AutoScore(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT));
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
