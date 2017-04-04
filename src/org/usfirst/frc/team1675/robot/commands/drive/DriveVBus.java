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
    	Robot.driveBase.setMotorPower(power);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveBase.setMotorPower(0);
    			
    }
    
    protected void interrupted() {
    	end();
    }
}
