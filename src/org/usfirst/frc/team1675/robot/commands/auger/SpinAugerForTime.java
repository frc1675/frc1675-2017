package org.usfirst.frc.team1675.robot.commands.auger;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinAugerForTime extends SpinAuger {

	public SpinAugerForTime(double power, double timeToWait) {
		super(power);
		setTimeout(timeToWait);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return isTimedOut();
	}

}
