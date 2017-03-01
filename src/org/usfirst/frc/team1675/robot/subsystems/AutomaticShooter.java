package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class AutomaticShooter extends PIDSubsystem {
	private CANTalon leftFireMotor;
	private CANTalon rightFireMotor;
	private Counter counter;
	public boolean isSpinning;
	public boolean isShooting;
	public boolean atSpeed;

	public AutomaticShooter() {
		super(RobotMap.ShooterConstants.P, RobotMap.ShooterConstants.I, RobotMap.ShooterConstants.D);
		leftFireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_LEFT);
		rightFireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_RIGHT);

		counter = new Counter(RobotMap.DIOChannels.SHOOTER_COUNTER);
		counter.setDistancePerPulse(1);// sets a scaling value for getRate

		leftFireMotor.setInverted(false);
		rightFireMotor.setInverted(true);

		this.getPIDController().setSetpoint(RobotMap.ShooterConstants.SETPOINT_RPM
				* RobotMap.ShooterConstants.COUNTER_PULSES_PER_REVOLUTION / 60.0);
		this.getPIDController().setOutputRange(0, 1);
		this.getPIDController().setPercentTolerance(5);
		this.getPIDController().setToleranceBuffer(10);
	}

	public void setShooterSetpoint(double set) {
		this.getPIDController().setSetpoint(set);
	}

	public void setMotorPower(double power) {
		setLeftMotorPower(power);
		setRightMotorPower(power);
	}

	private void setLeftMotorPower(double power) {
		power = scaledDeadzone(power);
		leftFireMotor.set(power);
	}

	private void setRightMotorPower(double power) {
		power = scaledDeadzone(power);
		rightFireMotor.set(power);
	}

	public double getRPM() {
		return counter.getRate() * 60.0 / RobotMap.ShooterConstants.COUNTER_PULSES_PER_REVOLUTION;
		// 60 comes from 60 seconds per minute
	}

	public double getPulseRate() {
		return counter.getRate();
	}

	public int getPulseCount() {
		return counter.get();
	}

	public double getCurrent(int motorChannel) {
		return Robot.pdp.getShooterCurrents(motorChannel);
	}

	public void enable() {
		this.getPIDController().enable();
	}

	public void reset() {
		this.getPIDController().reset();
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.ShooterConstants.MAX_POWER - RobotMap.ShooterConstants.DEADZONE) * Math.abs(power)
						+ RobotMap.ShooterConstants.DEADZONE);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		return getPulseRate();
	}

	protected void usePIDOutput(double output) {
		setLeftMotorPower(output);
		setRightMotorPower(output);
	}
}