package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoScore extends Command {
	
	private static final double AUTO_SCORE_TIMER_MAX = 1.0;
	private static final double CLAW_UP_START = 0.5;	
	private static final double CLAW_UP_END = 1.0;
	private static final double CLAW_DOWN_START = 0.0;
	private static final double CLAW_DOWN_END = 0.5;
	private static final double BACKUP_SPIT_START = 0.25;
	private static final double BACKUP_SPIT_END = 0.5;
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
		if(time > BACKUP_SPIT_START && time < BACKUP_SPIT_END){
			Robot.gearManipulator.runGearManipulator(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT);
			Robot.driveBase.setLeftMotors(-1.0);
			Robot.driveBase.setRightMotors(-1.0);
			
		} else {
			Robot.gearManipulator.runGearManipulator(RobotMap.GearManipulatorConstants.GEAR_SPINNER_STOPPED);
			Robot.driveBase.setLeftMotors(0.0);
			Robot.driveBase.setRightMotors(0.0);
		}
		
		if(time > CLAW_DOWN_START && time <= CLAW_DOWN_END){
			Robot.gearManipulator.deployGearManipulator();
		} else if (time > CLAW_UP_START && time < CLAW_UP_END) {
			Robot.gearManipulator.retractGearManipulator();
		}
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > AUTO_SCORE_TIMER_MAX;
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
