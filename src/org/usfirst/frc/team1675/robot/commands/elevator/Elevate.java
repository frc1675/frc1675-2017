package org.usfirst.frc.team1675.robot.commands.elevator;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevate extends Command {
	
	double power;

    public Elevate(double pow) {
    	power = pow;
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.setElevatorPower(power);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.elevator.setElevatorPower(0);
    }

    protected void interrupted() {
    	end();
    }
}
