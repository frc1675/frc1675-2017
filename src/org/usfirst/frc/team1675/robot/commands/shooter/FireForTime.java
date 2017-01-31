package org.usfirst.frc.team1675.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireForTime extends Command {

    public FireForTime(double rpmSetpoint, double secondsForTimeout) {
        super(rpmSetpoint);
        this.setTimeout(secondsForTimeout);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }
}
