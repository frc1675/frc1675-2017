package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SpinAuger extends Command {
	
	public static final int SpinBackwards = 1;
	public static final int SpinForward = -1;
	
	private int spinDirection;
	
    public SpinAuger(int spinDirection) {
    	requires(Robot.auger);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.spinDirection = spinDirection;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.auger.setAugerPower(spinDirection);    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
