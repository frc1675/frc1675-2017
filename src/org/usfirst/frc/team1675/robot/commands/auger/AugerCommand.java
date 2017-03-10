package org.usfirst.frc.team1675.robot.commands.auger;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AugerCommand extends Command {

	private AugerState augerState;

	private double startJamTime;
	private double startUnjamTime;
	private double startDoubleJamTime;
	private double startSettleTime;

	public AugerCommand() {
		requires(Robot.auger);

	}

	private void megaStopped() {
		Robot.auger.setAugerPower(0);
		if (!Robot.autoShooter.isShooting()) {
			augerState = AugerState.STOPPED;
			System.out.println("Stopped");
		}
	}

	private void stopped() {
		Robot.auger.setAugerPower(0);
		if (Robot.autoShooter.isShooting() && Robot.autoShooter.onTarget()) {
			augerState = AugerState.RUNNING_FORWARD;
			startJamTime = this.timeSinceInitialized();//makes sure that it doesn't claim being jammed at the beginning if there's a beginning current spike
			System.out.println("Running_Forward");
		}
	}

	private void runningForward() {
		Robot.auger.setAugerPower(RobotMap.AugerConstants.FORWARDS_POWER);
		if (Robot.auger.getCurrent() < RobotMap.AugerConstants.FORWARDS_CURRENT_THRESHOLD) {
			startJamTime = this.timeSinceInitialized(); //resets jam	
		}
		if (this.timeSinceInitialized() - startJamTime > RobotMap.AugerConstants.MIN_JAM_SECONDS) {
			augerState = AugerState.RUNNING_BACKWARDS;
			startUnjamTime = this.timeSinceInitialized();
			startDoubleJamTime = this.timeSinceInitialized();
			System.out.println("Running_Backwards");
		} else if(!(Robot.autoShooter.isShooting() && Robot.autoShooter.onTarget())) {
			augerState = AugerState.STOPPED;
			System.out.println("Stopped");
		}
	

	}

	private void runningBackwards() {
		Robot.auger.setAugerPower(RobotMap.AugerConstants.BACKWARDS_POWER);
		if (Robot.auger.getCurrent() < RobotMap.AugerConstants.BACKWARDS_CURRENT_THRESHOLD) {
			startDoubleJamTime = this.timeSinceInitialized();
			if (this.timeSinceInitialized() - startUnjamTime > RobotMap.AugerConstants.UNJAM_DURATION) {
				augerState = AugerState.SETTLING;
				startSettleTime = this.timeSinceInitialized();
				System.out.println("Settling");
			}
		} else if (this.timeSinceInitialized() - startDoubleJamTime > RobotMap.AugerConstants.MIN_DOUBLE_JAM_SECONDS) {
			augerState = AugerState.MEGA_STOP;
			System.out.println("Mega Stop");
		}
	}

	public void settling() {
		Robot.auger.setAugerPower(0);
		if (this.timeSinceInitialized() - startSettleTime > RobotMap.AugerConstants.SETTLE_DURATION) {
			if (Robot.autoShooter.isShooting() && Robot.autoShooter.onTarget()) {
				augerState = AugerState.RUNNING_FORWARD;
				startJamTime = this.timeSinceInitialized();//makes sure that it doesn't claim being jammed at the beginning if there's a beginning current spike
				System.out.println("Running_Forward");
			}else{
				augerState = AugerState.STOPPED;
				System.out.println("Stopped");
			}
		}

	}

	public static enum AugerState {
		STOPPED, RUNNING_FORWARD, RUNNING_BACKWARDS, SETTLING, MEGA_STOP
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		augerState = AugerState.STOPPED;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putString("Auger State", augerState.toString());
		switch (augerState) {
		case STOPPED:
			this.stopped();
			break;
		case RUNNING_FORWARD:
			this.runningForward();
			break;
		case RUNNING_BACKWARDS:
			this.runningBackwards();
			break;
		case SETTLING:
			this.settling();
			break;
		case MEGA_STOP:
			this.megaStopped();
			break;
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.auger.setAugerPower(0);
	}

	protected void interrupted() {
		end();
	}
}
