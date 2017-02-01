package org.usfirst.frc.team1675.robot.commands.shooter;

/**
 *
 */
public class FireForTime extends Fire {

    public FireForTime(double rpmSetpoint, double seconds) {
        super(rpmSetpoint);
        this.setTimeout(seconds);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }
}