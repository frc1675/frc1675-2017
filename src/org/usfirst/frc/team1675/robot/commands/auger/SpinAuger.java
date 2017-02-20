package org.usfirst.frc.team1675.robot.commands.auger;

import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SpinAuger extends Command {

	private double spinPower;

	public SpinAuger(double spinPower) {
		requires(Robot.auger);
		this.spinPower = spinPower;
	}

	protected void initialize() {
		Robot.auger.setAugerPower(spinPower);
	}

	protected void execute() {
		SmartDashboard.putNumber("Auger Current", Robot.auger.getCurrent());
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