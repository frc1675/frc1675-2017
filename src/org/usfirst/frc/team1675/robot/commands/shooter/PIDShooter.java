package org.usfirst.frc.team1675.robot.commands.shooter;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDShooter extends PIDCommand {
		
	double rpmSetpoint;

    public PIDShooter(double rpmSetpoint) {
    	super(RobotMap.ShooterConstants.P,RobotMap.ShooterConstants.I,RobotMap.ShooterConstants.D);
    	requires(Robot.shooter);
    	this.rpmSetpoint = rpmSetpoint;
    }

    protected void initialize() {
    	this.getPIDController().reset();
    	this.getPIDController().enable();
    	this.getPIDController().setSetpoint(rpmSetpoint);
    	this.getPIDController().setOutputRange(0, 1);
    }

    protected void execute() {
    	SmartDashboard.putNumber("Shooter PID error", this.getPIDController().getAvgError());
    	SmartDashboard.putNumber("P", this.getPIDController().getP());
    	SmartDashboard.putNumber("I", this.getPIDController().getI());
    	SmartDashboard.putNumber("D", this.getPIDController().getD());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	this.getPIDController().disable();
    	Robot.shooter.setMotorPower(0);
    }

    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		SmartDashboard.putNumber("PID SHOOTER INPUT", Robot.shooter.getMotorRPM());

		return Robot.shooter.getMotorRPM();
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("PID SHOOTER OUTPUT", output);
		
		Robot.shooter.setMotorPower(output);
	}
}
