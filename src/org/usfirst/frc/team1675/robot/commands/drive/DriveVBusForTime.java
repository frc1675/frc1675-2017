package org.usfirst.frc.team1675.robot.commands.drive;

/**
 *
 */
public class DriveVBusForTime extends DriveVBus {

    public DriveVBusForTime(double power, double seconds) {
    	super(power);
    	this.setTimeout(seconds);
    }
    
    @Override
    protected boolean isFinished() {
        return this.isTimedOut();
    }
}
