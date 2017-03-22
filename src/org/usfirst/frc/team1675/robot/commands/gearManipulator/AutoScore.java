package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoScore extends Command {
	
	double power;
	Timer timer;

    public AutoScore(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearManipulator);
    	requires(Robot.driveBase);
    	this.power = power;
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearManipulator.runGearManipulator(power);
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		
		double time = timer.get();
		if(time > 0.25 && time < 0.5){
			Robot.driveBase.setLeftMotors(-1.0);
			Robot.driveBase.setRightMotors(-1.0);
			
		} else {
			Robot.gearManipulator.runGearManipulator(0.0);
			Robot.driveBase.setLeftMotors(0.0);
			Robot.driveBase.setRightMotors(0.0);
		}
		
		if(time > 0.0 && time <= 0.5){
			Robot.gearManipulator.deployGearManipulator();
		} else if (time > 0.5 && time < 1.0) {
			Robot.gearManipulator.retractGearManipulator();
		}
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > 1.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
