package org.usfirst.frc.team1675.robot.commands.autoShooter;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IncrementRPM extends Command {
	private double rpmIncrement;
	
    public IncrementRPM(double rpmIncrement) {
    	this.rpmIncrement = rpmIncrement;
    }

    protected void initialize() {
    	Robot.autoShooter.incrementRPMSetpoint(rpmIncrement);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
