package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	CANTalon elevator;

	public Elevator() {
		elevator = new CANTalon(RobotMap.CANDeviceIDs.ELEVATOR_MOTOR);
	}

	public void setElevatorPower(double power) {
		power = motorDeadzone(power);
		elevator.set(power);
	}

	public double getSpeed() {
		return elevator.getSpeed();
	}

	public double getRPM() {
		return elevator.getEncVelocity() * 600 / RobotMap.MotorConstants.ENCODER_TICKS_PER_ROTATION;
	}

	private double motorDeadzone(double power) {
		return Math.signum(power) * ((1 - RobotMap.MotorConstants.ELEVATOR_DEADZONE) * Math.abs(power)
				+ RobotMap.MotorConstants.ELEVATOR_DEADZONE);
	}

	public void initDefaultCommand() {
	}
}