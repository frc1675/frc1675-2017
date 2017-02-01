package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon fireMotor;

	public Shooter() {
		fireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_MOTOR);
	}

	public void setPower(double power) {
		power = scalePower(power);
		fireMotor.set(power);
	}

	public double getEncVelocity() {
		return fireMotor.getEncVelocity();
	}

	public double getRPM() {
		return fireMotor.getEncVelocity() * 600 / RobotMap.ShooterConstants.ENCODER_TICKS_PER_ROTATION;
	}

	private double scalePower(double power) {
		return Math.signum(power) * ((RobotMap.ShooterConstants.MAX_POW - RobotMap.ShooterConstants.DEADZONE) * Math.abs(power)
				+ RobotMap.ShooterConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}