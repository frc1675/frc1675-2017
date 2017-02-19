package org.usfirst.frc.team1675.robot.commands.shooter;

/**
 *
 */
public class PIDShooterUntilOnTarget extends PIDShooter {

    public PIDShooterUntilOnTarget(double rpmSetpoint) {
        super(rpmSetpoint);
    }
    
    @Override
    protected void initialize() {
    	super.initialize();
    	this.getPIDController().setPercentTolerance(5);
    	this.getPIDController().setToleranceBuffer(10);
    }
    
    @Override
    protected boolean isFinished() {
        return this.getPIDController().onTarget();
    }
    
    @Override
    protected void end() {
    	
    }
    
    @Override
    protected void interrupted() {
    	super.end();
    }
    
}
