package org.usfirst.frc.team1675.robot.commands.shooter;

/**
 *
 */
public class FireForTime extends Fire {

    public FireForTime(double rpmSetpoint, double secondsForTimeout) {
        super(rpmSetpoint);
        this.setTimeout(secondsForTimeout);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }
}