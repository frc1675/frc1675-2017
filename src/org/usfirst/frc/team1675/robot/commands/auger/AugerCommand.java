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
	private double startUnjamTime;
	private double startDJamTime;
	private double startSettleTime;
	
    public AugerCommand() {
    	requires(Robot.auger);
    	
    }
    
    private void megaStop(){
    	Robot.auger.setAugerPower(0);
    	if(!(Robot.shooter.isShooting || Robot.shooter.isSpinning)){
    		augerState = AugerState.STOPPED;
    	}
    }
    
    private void stop(){
    	Robot.auger.setAugerPower(0);
    	if(Robot.shooter.isShooting && Robot.shooter.isUpToSpeed){
    		augerState = AugerState.RUNNING_FORWARD;
    	}
    }
    
    private void runningForward(){
    	Robot.auger.setAugerPower(RobotMap.AugerConstants.FORWARDS_POWER);
    	if(Robot.auger.getCurrent() < RobotMap.AugerConstants.MAX_CURRENT){
    		startJamTime = this.timeSinceInitialized();
    	}else if(this.timeSinceInitialized() - startJamTime > RobotMap.AugerConstants.MIN_JAM_SECONDS){
    		augerState = AugerState.RUNNING_BACKWARDS;
    		startUnjamTime = this.timeSinceInitialized();
    	}
    }
    
    private void runningBackward(){
    	Robot.auger.setAugerPower(RobotMap.AugerConstants.BACKWARDS_POWER);
    	if(Robot.auger.getCurrent() < RobotMap.AugerConstants.MAX_CURRENT){
    		startDJamTime = this.timeSinceInitialized();
    		if(this.timeSinceInitialized() - startUnjamTime > RobotMap.AugerConstants.MIN_UNJAM_SECONDS){
    			augerState = AugerState.SETTLING;
    			startSettleTime = this.timeSinceInitialized();
    		}
    	}else if(this.timeSinceInitialized() - startDJamTime > RobotMap.AugerConstants.MIN_D_JAM_SECONDS){
    		augerState = AugerState.MEGA_STOP;
    	}
    }
    
    public void settling(){
    	Robot.auger.setAugerPower(0);
    	if(this.timeSinceInitialized() - startSettleTime > RobotMap.AugerConstants.MIN_SETTLE_SECONDS){
    		augerState = AugerState.RUNNING_FORWARD;
    	}
    	
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
    		this.stop();
    		break;
    	case RUNNING_FORWARD:
    		this.runningForward();
    		break;
    	case RUNNING_BACKWARDS:
    		this.runningBackward();
    		break;
    	case SETTLING:
    		this.settling();
    		break;
    	case MEGA_STOP:
    		this.megaStop();
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
