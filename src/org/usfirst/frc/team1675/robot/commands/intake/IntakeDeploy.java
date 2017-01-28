package org.usfirst.frc.team1675.robot.commands.intake;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeDeploy extends Command {

	public IntakeDeploy() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
		this.setTimeout(RobotMap.IntakeConstants.INTAKE_SOLENOID_ACTIVE_TIME);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.deployIntake();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.haltIntakeDeploy();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
