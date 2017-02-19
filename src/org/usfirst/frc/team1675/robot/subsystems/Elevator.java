package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private CANTalon leftElevatorMotor;
	private CANTalon rightElevatorMotor;
	
	public Elevator() {
		leftElevatorMotor = new CANTalon(RobotMap.CANDeviceIDs.LEFT_ELEVATOR_MOTOR);
		rightElevatorMotor = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_ELEVATOR_MOTOR);
		
		leftElevatorMotor.setInverted(true);
		rightElevatorMotor.setInverted(false);
	}

	public void setElevatorPower(double power) {
		power = scaledDeadzone(power);
		leftElevatorMotor.set(power);
		rightElevatorMotor.set(power);
	}
	public double getCurrent(int motorChannel){
		return Robot.pdp.getElevatorCurrents(motorChannel);
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.ElevatorConstants.MAX_POWER - RobotMap.ElevatorConstants.DEADZONE)
						* Math.abs(power) + RobotMap.ElevatorConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}