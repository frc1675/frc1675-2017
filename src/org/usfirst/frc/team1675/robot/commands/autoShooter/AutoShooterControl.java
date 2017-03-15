package org.usfirst.frc.team1675.robot.commands.autoShooter;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	Robot.elevator.setElevatorPower(RobotMap.ElevatorConstants.FORWARDS_POWER);
    	state = ShooterState.STOPPED;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("Shooter State", state.toString());
    	
		SmartDashboard.putNumber("Shooter RPM", Robot.autoShooter.getRPM());
		SmartDashboard.putNumber("Avg Error", Robot.autoShooter.getPIDController().getAvgError());
		SmartDashboard.putNumber("Error", Robot.autoShooter.getPIDController().getError());
		SmartDashboard.putNumber("RPM Setpoint", Robot.autoShooter.getRPMSetpoint());
		
		SmartDashboard.putBoolean("On Target", Robot.autoShooter.onTarget());
		SmartDashboard.putBoolean("Spinning", Robot.autoShooter.isSpinning());
		SmartDashboard.putBoolean("Shooting", Robot.autoShooter.isShooting());
		
    	switch(state){
    	case STOPPED:
    		Robot.autoShooter.reset();
    		Robot.elevator.setElevatorPower(0);
    		Robot.autoShooter.setSetpoint(Robot.autoShooter.getSetpoint());
    		if(Robot.autoShooter.isSpinning() || Robot.autoShooter.isShooting()){
    			state = ShooterState.MAINTAINING;
    			//set the setpoint to clear the buffer
    			
    		}
    		break;
    	case MAINTAINING:
    		Robot.autoShooter.enable();
    		//set the setpoint again to clear the buffer
    		Robot.elevator.setElevatorPower(0);
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
    	Robot.autoShooter.disableReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
