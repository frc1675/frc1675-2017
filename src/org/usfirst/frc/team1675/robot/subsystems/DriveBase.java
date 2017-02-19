package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
	private CANTalon leftFront;
	private CANTalon leftBack;
	private CANTalon rightFront;
	private CANTalon rightBack;
	private DoubleSolenoid shifter;

	public DriveBase() {
		leftFront = new CANTalon(RobotMap.CANDeviceIDs.LEFT_FRONT_MOTOR);
		leftBack = new CANTalon(RobotMap.CANDeviceIDs.LEFT_BACK_MOTOR);
		rightFront = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_FRONT_MOTOR);
		rightBack = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_BACK_MOTOR);
		shifter = new DoubleSolenoid(RobotMap.SolenoidChannels.SHIFT_LOW,
				RobotMap.SolenoidChannels.SHIFT_HIGH);
		
		leftFront.setInverted(true);
		leftBack.setInverted(true);
		rightFront.setInverted(false);
		rightBack.setInverted(false);

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
				* ((RobotMap.DriveBaseConstants.MAX_POWER - RobotMap.DriveBaseConstants.DEADZONE) * Math.abs(power)
						+ RobotMap.DriveBaseConstants.DEADZONE);
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
	public double getCurrent(int motorChannel){
		return Robot.pdp.getDriveMotorCurrents(motorChannel);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}
}