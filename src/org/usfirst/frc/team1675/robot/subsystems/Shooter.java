package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon leftFireMotor;
	private CANTalon rightFireMotor; 

	public Shooter() {
		leftFireMotor = new CANTalon(RobotMap.CANDeviceIDs.LEFT_SHOOTER_MOTOR);
		rightFireMotor = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_SHOOTER_MOTOR);
		
		
	}

	public void setPower(double power) {
		power = scaledDeadzone(power);
		leftFireMotor.set(power);
		rightFireMotor.set(power);
	}

	public double getRPM() {
		return leftFireMotor.getEncVelocity() * 600.0 / RobotMap.ShooterConstants.ENCODER_TICKS_PER_REVOLUTION;
		//600 comes from 60 seconds per minute times times 10 tenths of a second per second
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power) * ((RobotMap.ShooterConstants.MAX_POWER - RobotMap.ShooterConstants.DEADZONE) * Math.abs(power)
				+ RobotMap.ShooterConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}