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
		power = scalePower(power);
		elevator.set(power);
	}

	public double getSpeed() {
		return elevator.getSpeed();
	}

	private double scalePower(double power) {
		return Math.signum(power)
				* ((RobotMap.ElevatorConstants.MAX_POW - RobotMap.ElevatorConstants.ELEVATOR_DEADZONE)
						* Math.abs(power) + RobotMap.ElevatorConstants.ELEVATOR_DEADZONE);
	}

	public void initDefaultCommand() {
	}
}