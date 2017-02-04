package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.CheeseDrive;
import org.usfirst.frc.team1675.robot.commands.drive.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
	CANTalon leftFront;
	CANTalon leftBack;
	CANTalon rightFront;
	CANTalon rightBack;
	DoubleSolenoid shifter;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public DriveBase() {
		leftFront = new CANTalon(RobotMap.CANDeviceIDs.LEFT_FRONT_MOTOR);
		leftBack = new CANTalon(RobotMap.CANDeviceIDs.LEFT_BACK_MOTOR);
		rightFront = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_FRONT_MOTOR);
		rightBack = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_BACK_MOTOR);
		shifter = new DoubleSolenoid(RobotMap.SolenoidChannels.SHIFT_LOW,
				RobotMap.SolenoidChannels.SHIFT_HIGH);
	}

	public void setRightMotors(double power) {
		power = motorDeadzone(power);
		rightFront.set(power);
		rightBack.set(power);
	}

	public void setLeftMotors(double power) {
		power = motorDeadzone(power);
		leftFront.set(-power);
		leftBack.set(-power);
	}

	private double motorDeadzone(double power) {
		if (power == 0) {
			return 0;
		} else {
			return Math.signum(power)
					* ((1 - RobotMap.DriveBaseConstants.MOTOR_DEADZONE)
							* Math.abs(power) + RobotMap.DriveBaseConstants.MOTOR_DEADZONE);
		}
	}

	public void shiftHigh() {
		shifter.set(DoubleSolenoid.Value.kForward);
	}

	public void shiftLow() {
		shifter.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopShifter() {
		shifter.set(DoubleSolenoid.Value.kOff);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheeseDrive());
	}
}
