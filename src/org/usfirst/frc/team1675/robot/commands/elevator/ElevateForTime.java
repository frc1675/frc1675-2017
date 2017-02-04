package org.usfirst.frc.team1675.robot.commands.elevator;

/**
 *
 */
public class ElevateForTime extends Elevate {

	public ElevateForTime(double power, double seconds) {
		super(power);
		this.setTimeout(seconds);
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
}