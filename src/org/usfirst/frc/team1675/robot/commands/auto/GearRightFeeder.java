package org.usfirst.frc.team1675.robot.commands.auto;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.Wait;
import org.usfirst.frc.team1675.robot.commands.drive.DriveForDistance;
import org.usfirst.frc.team1675.robot.commands.drive.TurnOnGyro;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.AutoScore;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearRightFeeder extends CommandGroup {
	
	private static final double SEGMENT_1 = 73.8;
	private static final double SEGMENT_1_TIMEOUT = 4.0;
	
	private static final double TURN_ANGLE = -58.0;
	private static final double TURN_TIMEOUT = 4.0;
	
	private static final double SEGMENT_2 = 64.8;
	private static final double SEGMENT_2_TIMEOUT = 4.0;

    public GearRightFeeder() {
        // Add Commands here:
    	addSequential(new DriveForDistance(SEGMENT_1, SEGMENT_1_TIMEOUT));
        addSequential(new TurnOnGyro(TURN_ANGLE, TURN_TIMEOUT));
        addSequential(new Wait(0.5));
        addSequential(new DriveForDistance(SEGMENT_2, SEGMENT_2_TIMEOUT));
        addSequential(new AutoScore(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT));
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
