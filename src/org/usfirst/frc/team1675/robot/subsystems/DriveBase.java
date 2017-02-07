package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.CheeseDrive;
import org.usfirst.frc.team1675.robot.utilities.PowerDistribution;

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

	public DriveBase() {
		leftFront = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_LEFT_FRONT);
		leftBack = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_LEFT_BACK);
		rightFront = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_RIGHT_FRONT);
		rightBack = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_RIGHT_BACK);
		shifter = new DoubleSolenoid(RobotMap.SolenoidChannels.SHIFT_LOW, RobotMap.SolenoidChannels.SHIFT_HIGH);
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

	public void shiftHigh() {
		shifter.set(DoubleSolenoid.Value.kForward);
	}

	public void shiftLow() {
		shifter.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopShifter() {
		shifter.set(DoubleSolenoid.Value.kOff);
	}

	public double getLeftFrontCurrent() {
		return Robot.pdp.getMotorCurrent(RobotMap.PDChannels.DRIVE_LEFT_FRONT);
	}
	
	public double getLeftBackCurrent() {
		return Robot.pdp.getMotorCurrent(RobotMap.PDChannels.DRIVE_LEFT_BACK);
	}
	
	public double getRightFrontCurrent() {
		return Robot.pdp.getMotorCurrent(RobotMap.PDChannels.DRIVE_RIGHT_FRONT);
	}
	
	public double getRightBackCurrent() {
		return Robot.pdp.getMotorCurrent(RobotMap.PDChannels.DRIVE_RIGHT_BACK);
	}
	
	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.DriveBaseConstants.MAX_POWER - RobotMap.DriveBaseConstants.DEADZONE) * Math.abs(power)
						+ RobotMap.DriveBaseConstants.DEADZONE);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheeseDrive());
	}
}