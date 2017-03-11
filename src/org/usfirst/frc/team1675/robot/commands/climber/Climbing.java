package org.usfirst.frc.team1675.robot.commands.climber;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Climbing extends Command {
	double power;

	public Climbing(double power) {
		requires(Robot.climber);

		this.power = power;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run

	@Override
	protected void execute() {
		Robot.climber.climberSpinner(power);
	}

	// Make this return true when this Command no longer needs to run execute()
	// protected boolean isFinished() {
	// if (Robot.climber.getClimberCurrents() <
	// RobotMap.ClimberConstants.CLIMBER_POWER) {
	// return false;
	// } else {
	// return true;
	// }
	// }

	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.climber.climberSpinner(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
