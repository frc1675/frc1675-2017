package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PIDDriveWithGyro extends CommandGroup {

    public PIDDriveWithGyro(double distance,double timeout) {
    	requires(Robot.driveBase);
    	addParallel(new LeftSidePIDDrive(distance,timeout));
    	addParallel(new RightSidePIDDrive(distance,timeout));
    }
}
