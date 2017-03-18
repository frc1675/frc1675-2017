package org.usfirst.frc.team1675.robot.commands.gearManipulator;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearManipulating extends Command {

	private double power;

	public GearManipulating(double power) {
		requires(Robot.gearManipulator);
		this.power = power;
	}

	protected void initialize() {
		Robot.gearManipulator.runGearManipulator(power);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.gearManipulator.runGearManipulator(0);
	}

	protected void interrupted() {
		end();
	}
}
