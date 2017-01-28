package org.usfirst.frc.team1675.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevateForTime extends Elevate {

    public ElevateForTime(double power, double seconds) {
    	super(power);
    	this.setTimeout(seconds);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }
}
