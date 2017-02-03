package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private CANTalon elevator;

	public Elevator() {
		elevator = new CANTalon(RobotMap.CANDeviceIDs.ELEVATOR_MOTOR);
	}

	public void setElevatorPower(double power) {
		power = scaledDeadzone(power);
		elevator.set(power);
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.ElevatorConstants.MAX_POWER - RobotMap.ElevatorConstants.DEADZONE)
						* Math.abs(power) + RobotMap.ElevatorConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}