package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Auger extends Subsystem {

	private CANTalon augerController;

	public Auger() {
		augerController = new CANTalon(RobotMap.CANDeviceIDs.AUGER);
		augerController.setInverted(true);
	}

	public void setAugerPower(double power) {
		power = scaledDeadzone(power);
		augerController.set(power);

	}
	public double getCurrent(){
		return Robot.pdp.getAugerCurrent();
	}
	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.AugerConstants.MAX_POWER - RobotMap.AugerConstants.DEADZONE)
						* Math.abs(power) + RobotMap.AugerConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}