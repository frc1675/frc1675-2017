package org.usfirst.frc.team1675.robot.commands.auger;

/**
 *
 */
public class SpinAugerForTime extends SpinAuger {

	public SpinAugerForTime(double power, double timeToWait) {
		super(power);
		setTimeout(timeToWait);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
}