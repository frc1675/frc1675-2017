package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveVBus extends Command {
	private double power;

    public DriveVBus(double power) {
    	requires(Robot.driveBase);
    	this.power = power;
    }

    protected void initialize() {
    	Robot.driveBase.setLeftMotors(power);
    	Robot.driveBase.setRightMotors(power);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveBase.setLeftMotors(0);
    	Robot.driveBase.setRightMotors(0);
    			
    }
    
    protected void interrupted() {
    	end();
    }
}
