package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.CheeseDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveBase extends Subsystem {
	private TalonSRX leftFront;
	private TalonSRX leftBack;
	private TalonSRX rightFront;
	private TalonSRX rightBack;
	private DoubleSolenoid shifter;
	AHRS ahrs;

	public DriveBase() {
		leftFront = new TalonSRX(RobotMap.CANDeviceIDs.DRIVE_LEFT_FRONT);
		leftBack = new TalonSRX(RobotMap.CANDeviceIDs.DRIVE_LEFT_BACK);
		rightFront = new TalonSRX(RobotMap.CANDeviceIDs.DRIVE_RIGHT_FRONT);
		rightBack = new TalonSRX(RobotMap.CANDeviceIDs.DRIVE_RIGHT_BACK);
		shifter = new DoubleSolenoid(RobotMap.SolenoidChannels.SHIFT_LOW,
				RobotMap.SolenoidChannels.SHIFT_HIGH);
		
		ahrs = new AHRS(SerialPort.Port.kMXP);
		
		leftFront.setInverted(true);
		leftBack.setInverted(true);
		rightFront.setInverted(false);
		rightBack.setInverted(false);
		
		rightFront.setSensorPhase(true);
		leftFront.setSensorPhase(true);
	}
	public void setLeftMotors(double power){
		power = scaledDeadzone(power);
		SmartDashboard.putNumber("motors", power);
		leftFront.set(ControlMode.PercentOutput,power);
		leftBack.set(ControlMode.PercentOutput,power);
	}
	public void setRightMotors(double power){
		power = scaledDeadzone(power);
		rightFront.set(ControlMode.PercentOutput,power);
		rightBack.set(ControlMode.PercentOutput,power);
	}

	public void setMotorPower(double power) {
		power = scaledDeadzone(power);
		leftFront.set(ControlMode.PercentOutput,power);
		leftBack.set(ControlMode.PercentOutput,power);
		rightFront.set(ControlMode.PercentOutput,power);
		rightBack.set(ControlMode.PercentOutput,power);
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
	public void resetEncoder() {
		leftFront.getSensorCollection().setQuadraturePosition(0,0);
		rightFront.getSensorCollection().setQuadraturePosition(0,0);
	}

	public double getLeftEncoderValue() {
		return leftFront.getSelectedSensorPosition(0);
	}
	public double getRightEncoderValue() {
		return rightFront.getSelectedSensorPosition(0);
	}
	public double getAngle() {
		return ahrs.getAngle();
	}

	public void resetGyro() {
		ahrs.zeroYaw();
	}

	public void stopShifter() {
		shifter.set(DoubleSolenoid.Value.kOff);
	}
	public double getCurrent(int motorChannel){
		return Robot.pdp.getDriveMotorCurrents(motorChannel);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheeseDrive());
	}

	
}