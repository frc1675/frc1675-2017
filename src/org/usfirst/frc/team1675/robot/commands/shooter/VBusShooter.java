package org.usfirst.frc.team1675.robot.commands.shooter;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VBusShooter extends Command {
	
	private double power;

    public VBusShooter(double power) {
        requires(Robot.shooter);
        this.power = power;
    }

    protected void initialize() {
    	Robot.shooter.setMotorPower(power);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooter.setMotorPower(0);
    }

    protected void interrupted() {
    	end();
    }
}
