package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.autoShooter.ChangeElevatorMotorState;
import org.usfirst.frc.team1675.robot.commands.drive.DriveVBusForTime;
import org.usfirst.frc.team1675.robot.commands.elevator.ElevateForTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootInAuto extends CommandGroup {

    public ShootInAuto() {
//    	addSequential(new ElevateForTime(RobotMap.ElevatorConstants.FORWARDS_POWER, .1));
    	addParallel(new ChangeElevatorMotorState(true));
    	addSequential(new Wait(8));
    	addParallel(new ChangeElevatorMotorState(false));
    	addSequential(new DriveVBusForTime(-.25, 5));

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
