package org.usfirst.frc.team1675.robot.commands.intake;

import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeFuel extends Command {

	private double power;
	
	public IntakeFuel(double power) {
		requires(Robot.intake);
		this.power = power;
	}

	protected void initialize() {
		Robot.intake.runIntake(power);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.intake.runIntake(0);
	}

	protected void interrupted() {
		end();
	}
}