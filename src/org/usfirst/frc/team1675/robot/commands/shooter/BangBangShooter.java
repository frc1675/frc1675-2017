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
		double rpmLeft = Math.abs(Robot.shooter.getLeftMotorRPM());
		double rpmRight = Math.abs(Robot.shooter.getRightMotorRPM());
		
		if (rpmLeft < rpmSetpoint) {
			Robot.shooter.setLeftMotorPower(RobotMap.ShooterConstants.BANGBANG_HIGH);
		} else {
			Robot.shooter.setLeftMotorPower(RobotMap.ShooterConstants.BANGBANG_LOW);
		}
		
		if (rpmRight < rpmSetpoint) {
			Robot.shooter.setRightMotorPower(RobotMap.ShooterConstants.BANGBANG_HIGH);
		} else {
			Robot.shooter.setRightMotorPower(RobotMap.ShooterConstants.BANGBANG_LOW);
		}
		
		SmartDashboard.putNumber("Shooter Left RPM:", rpmLeft);
		SmartDashboard.putNumber("Shooter Right RPM:", rpmRight);
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