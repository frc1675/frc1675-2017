package org.usfirst.frc.team1675.robot.commands.autoShooter;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShooterControl extends Command {

	public enum ShooterState{
		STOPPED,
		MAINTAINING,
		SCORING
	}
	ShooterState state;
    public AutoShooterControl() {
        requires(Robot.autoShooter);
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	state = ShooterState.STOPPED;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(state){
    	case STOPPED:
    		Robot.autoShooter.reset();
    		Robot.elevator.setElevatorPower(0);
    		if(Robot.autoShooter.isSpinning() || Robot.autoShooter.isShooting()){
    			state = ShooterState.MAINTAINING;
    		}
    		break;
    	case MAINTAINING:
    		Robot.autoShooter.enable();
    		if(Robot.autoShooter.onTarget() && Robot.autoShooter.isShooting()){
    			state = ShooterState.SCORING;
    		}else if(!Robot.autoShooter.isShooting() && !Robot.autoShooter.isSpinning()){
    			state = ShooterState.STOPPED;
    		}
    		break;
    	case SCORING:
    		Robot.elevator.setElevatorPower(RobotMap.ElevatorConstants.FORWARDS_POWER);
    		if(!Robot.autoShooter.onTarget() || !Robot.autoShooter.isShooting()){
    			state = ShooterState.MAINTAINING;
    		}else if(!Robot.autoShooter.isSpinning() && !Robot.autoShooter.isShooting()){
    			state = ShooterState.STOPPED;
    		}
    		break;
    	}
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
