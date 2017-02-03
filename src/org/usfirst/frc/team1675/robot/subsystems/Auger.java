package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Auger extends Subsystem {

	private CANTalon augerController;

	public Auger() {
		augerController = new CANTalon(RobotMap.CANDeviceIDs.AUGER_MOTOR);
	}

	public void setAugerPower(double power) {
		augerController.set(power);

	}

	public void initDefaultCommand() {
	}
}
