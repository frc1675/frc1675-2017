package org.usfirst.frc.team1675.robot.commands.shooter;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BangBangShooter extends Command {

	double rpmSetpoint;

	public BangBangShooter(double rpmSetpoint) {
		this.rpmSetpoint = rpmSetpoint;
		requires(Robot.shooter);
	}

	protected void initialize() {
	}

	protected void execute() {
		double rpm = Math.abs(Robot.shooter.getMotorRPM());
		
		if (rpm < rpmSetpoint) {
			Robot.shooter.setMotorPower(RobotMap.ShooterConstants.BANGBANG_HIGH);
		} else {
			Robot.shooter.setMotorPower(RobotMap.ShooterConstants.BANGBANG_LOW);
		}
		
		SmartDashboard.putNumber("Shooter RPM:", rpm);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.shooter.setMotorPower(0);
	}

	protected void interrupted() {
		end();
	}
}