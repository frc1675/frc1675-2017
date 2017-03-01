package org.usfirst.frc.team1675.robot.commands.auger;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AugerCommand extends Command {

	private AugerState augerState;
	
	private double startJamTime;
	
    public AugerCommand() {
    	requires(Robot.auger);
    	
    }
    
    public void megaStop(){
    	Robot.auger.setAugerPower(0);
    	if(!Robot.shooter.isShooting && !Robot.shooter.isSpinning){
    		augerState = AugerState.STOPPED;
    	}
    }	
    public void stop(){
    	Robot.auger.setAugerPower(0);
    	if(Robot.shooter.isShooting && Robot.shooter.isUpToSpeed){
    		augerState = AugerState.RUNNING_FORWARD;
    	}
    }
    
    public void runningForward(){
    	if(Robot.auger.getCurrent() < RobotMap.AugerConstants.MAX_CURRENT){
    		startJamTime = this.timeSinceInitialized();
    	}else if(this.timeSinceInitialized() - startJamTime > RobotMap.AugerConstants.MIN_JAM_SECONDS){
    		augerState = AugerState.RUNNING_BACKWARDS;
    	}
    	Robot.auger.setAugerPower(RobotMap.AugerConstants.FORWARDS_POWER);
    }
    
    public static enum AugerState{
    	STOPPED, RUNNING_FORWARD, RUNNING_BACKWARDS, SETTLING, MEGA_STOP
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	augerState = AugerState.STOPPED;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(augerState){
    	case STOPPED:
    		stop();
    		break;
    	case RUNNING_FORWARD:
    		runningForward();
    		break;
    	case RUNNING_BACKWARDS:
    		break;
    	case SETTLING:
    		break;
    	case MEGA_STOP:
    		megaStop();
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
