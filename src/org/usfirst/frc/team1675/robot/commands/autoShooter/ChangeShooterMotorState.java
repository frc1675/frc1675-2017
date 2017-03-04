package org.usfirst.frc.team1675.robot.commands.autoShooter;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeShooterMotorState extends Command {
	Boolean isSpinning;

    public ChangeShooterMotorState(boolean isRevving) {
    isSpinning = isRevving;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(isSpinning == true){
    		Robot.autoshooter.isSpinningTrue();
    	}
    	if(isSpinning == false){
    		Robot.autoshooter.isSpinningFalse();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
