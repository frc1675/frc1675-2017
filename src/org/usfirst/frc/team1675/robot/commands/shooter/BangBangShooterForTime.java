package org.usfirst.frc.team1675.robot.commands.shooter;

/**
 *
 */
public class BangBangShooterForTime extends BangBangShooter {

	public BangBangShooterForTime(double rpmSetpoint, double seconds) {
		super(rpmSetpoint);
		this.setTimeout(seconds);
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
}