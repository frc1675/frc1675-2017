package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drive.CheeseDrive;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SerialPort;
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
	AHRS ahrs;

	private boolean distanceOnTarget;
	private boolean straight;

	private double distancePIDOutput;
	private double straightenPIDOutput;

	public DriveBase() {
		leftFront = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_LEFT_FRONT);
		leftBack = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_LEFT_BACK);
		rightFront = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_RIGHT_FRONT);
		rightBack = new CANTalon(RobotMap.CANDeviceIDs.DRIVE_RIGHT_BACK);
		shifter = new DoubleSolenoid(RobotMap.SolenoidChannels.SHIFT_LOW, RobotMap.SolenoidChannels.SHIFT_HIGH);

		ahrs = new AHRS(SerialPort.Port.kMXP);

		distanceOnTarget = false;
		straight = false;
		distancePIDOutput = 0;
		straightenPIDOutput = 0;

		leftFront.setInverted(true);
		leftBack.setInverted(true);
		rightFront.setInverted(false);
		rightBack.setInverted(false);

		rightFront.reverseSensor(true);

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

	public void setMotorsPIDStraight(){
		double forward = distancePIDOutput * (1 - RobotMap.DriveBaseConstants.STRAIGHTEN_WEIGHTING);
		double straighten = straightenPIDOutput * RobotMap.DriveBaseConstants.STRAIGHTEN_WEIGHTING;
		setRightMotors(forward + straighten);
		setLeftMotors(forward - straighten);
	}

	public void shiftHigh() {
		shifter.set(DoubleSolenoid.Value.kForward);
	}

	public void shiftLow() {
		shifter.set(DoubleSolenoid.Value.kReverse);
	}

	public void resetEncoder() {
		leftFront.setEncPosition(0);
		rightFront.setEncPosition(0);
	}

	public void reverseEncoder(boolean reversed) {
		leftFront.reverseOutput(reversed);
		rightFront.reverseOutput(reversed);
	}

	public double getAverageEncoderValue() {
		return (getLeftEncoderValue() + getRightEncoderValue()) / 2;
	}
	
	public double getEncoderValueDifference(){
		return getLeftEncoderValue() - getRightEncoderValue();
	}

	public double getLeftEncoderValue() {
		return leftFront.getPosition();
	}

	public double getRightEncoderValue() {
		return rightFront.getPosition();
	}

	public double getAngle() {
		return ahrs.getAngle();
	}

	public boolean isDistanceOnTarget() {
		return distanceOnTarget;
	}

	public boolean isStraight() {
		return straight;
	}

	public void setDistanceOnTarget(boolean onTarget) {
		distanceOnTarget = onTarget;
	}

	public void setStraight(boolean onTarget) {
		straight = onTarget;
	}

	public void setDistancePIDOutput(double output) {
		distancePIDOutput = output;
	}

	public void setStraightenPIDOutput(double output) {
		straightenPIDOutput = output;
	}

	public void resetGyro() {
		ahrs.zeroYaw();
	}

	public void stopShifter() {
		shifter.set(DoubleSolenoid.Value.kOff);
	}

	public double getCurrent(int motorChannel) {
		return Robot.pdp.getDriveMotorCurrents(motorChannel);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CheeseDrive());
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.DriveBaseConstants.MAX_POWER - RobotMap.DriveBaseConstants.DEADZONE) * Math.abs(power)
						+ RobotMap.DriveBaseConstants.DEADZONE);
	}
}