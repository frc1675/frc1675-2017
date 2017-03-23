package org.usfirst.frc.team1675.robot.commands.auto;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.DriveForDistance;
import org.usfirst.frc.team1675.robot.commands.drive.TurnOnGyro;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.AutoScore;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftEscapeRight extends CommandGroup {

	private static final double TURN_1_ANGLE = -60.0;
	private static final double TURN_1_TIMEOUT = 4.0;
	
	private static final double SEGMENT_1 = 72.0;
	private static final double SEGMENT_1_TIMEOUT = 4.0;
	
	private static final double TURN_2_ANGLE = 90.0;
	private static final double TURN_2_TIMEOUT = 4.0;
	
	private static final double SEGMENT_2 = 120.0;
	private static final double SEGMENT_2_TIMEOUT = 5.0;
	
	private static final double TURN_3_ANGLE = -90.0;
	private static final double TURN_3_TIMEOUT = 4.0;
	
	private static final double SEGMENT_3 = 60.0;
	private static final double SEGMENT_3_TIMEOUT = 4.0;
	
    public LeftEscapeRight() {
        // Add Commands here:
    	addSequential(new TurnOnGyro(TURN_1_ANGLE, TURN_1_TIMEOUT));
    	addSequential(new DriveForDistance(SEGMENT_1, SEGMENT_1_TIMEOUT));
    	addSequential(new TurnOnGyro(TURN_2_ANGLE, TURN_2_TIMEOUT));
    	addSequential(new DriveForDistance(SEGMENT_2, SEGMENT_2_TIMEOUT));
    	addSequential(new TurnOnGyro(TURN_3_ANGLE, TURN_3_TIMEOUT));
    	addSequential(new DriveForDistance(SEGMENT_3, SEGMENT_3_TIMEOUT));
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
