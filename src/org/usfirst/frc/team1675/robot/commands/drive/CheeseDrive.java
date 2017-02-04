package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheeseDrive extends Command {

    public CheeseDrive() {
    	requires (Robot.driveBase);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double updown = Robot.oi.getDriverLeftYAxis();
    	double leftright = Robot.oi.getDriverRightXAxis();
    	Robot.driveBase.setLeftMotors(updown - leftright);
    	Robot.driveBase.setRightMotors(updown + leftright);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.setLeftMotors(0);
    	Robot.driveBase.setRightMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
