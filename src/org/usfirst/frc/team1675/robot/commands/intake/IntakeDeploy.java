package org.usfirst.frc.team1675.robot.commands.intake;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeDeploy extends Command {

	public IntakeDeploy() {
		requires(Robot.intake);
		this.setTimeout(RobotMap.IntakeConstants.SOLENOID_ACTIVE_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.intake.deployIntake();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.intake.stopSolenoids();
	}

	protected void interrupted() {
		end();
	}
}