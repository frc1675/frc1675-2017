package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.CheeseDrive;
import org.usfirst.frc.team1675.robot.commands.drive.TankDrive;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
	CANTalon leftFront;
	CANTalon leftBack;
	CANTalon rightFront;
	CANTalon rightBack;

	public DriveBase() {
		leftFront = new CANTalon(RobotMap.CANDeviceIDs.LEFT_FRONT_MOTOR);
		leftBack = new CANTalon(RobotMap.CANDeviceIDs.LEFT_BACK_MOTOR);
		rightFront = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_FRONT_MOTOR);
		rightBack = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_BACK_MOTOR);
	}

	public void setRightMotors(double power) {
		power = scaledDeadzone(power);
		rightFront.set(power);
		rightBack.set(power);
	}

	public void setLeftMotors(double power) {
		power = scaledDeadzone(power);
		leftFront.set(power);
		leftBack.set(power);
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.DriveConstants.MAX_POWER - RobotMap.DriveConstants.DEADZONE) * Math.abs(power)
						+ RobotMap.DriveConstants.DEADZONE);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheeseDrive());
	}
}