package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.autoShooter.AutoShooterControl;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutomaticShooter extends PIDSubsystem {
	private CANTalon leftFireMotor;
	private CANTalon rightFireMotor;
	private Counter counter;
	private boolean spinning;
	private boolean shooting;

	public AutomaticShooter() {
		super(RobotMap.ShooterConstants.P, RobotMap.ShooterConstants.I, RobotMap.ShooterConstants.D);
		leftFireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_LEFT);
		rightFireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_RIGHT);

		counter = new Counter(RobotMap.DIOChannels.SHOOTER_COUNTER);
		counter.setDistancePerPulse(1);// sets a scaling value for getRate

		leftFireMotor.setInverted(false);
		rightFireMotor.setInverted(true);

		this.setSetpoint(this.toPulseRate(RobotMap.ShooterConstants.SETPOINT_RPM));
		this.setOutputRange(0, 1);
		this.setInputRange(0, this.toPulseRate(RobotMap.ShooterConstants.MAX_RPM));
		this.setPercentTolerance(2);
		this.getPIDController().setToleranceBuffer(1);
		
		
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
		return this.toRPM(counter.getRate());
		// 60 comes from 60 seconds per minute
	}
	
	public double getRPMSetpoint(){
		return this.toRPM(this.getSetpoint());
	}
	
	public void incrementRPMSetpoint(double rpm){
		this.setSetpoint(this.toPulseRate(rpm) + this.getSetpoint());
	}
	
	public double toRPM(double pulseRate){
		return pulseRate * 60 / RobotMap.ShooterConstants.COUNTER_PULSES_PER_REVOLUTION;
		// 60 comes from 60 seconds per minute

	}
	
	public double toPulseRate(double rpm){
		return rpm * RobotMap.ShooterConstants.COUNTER_PULSES_PER_REVOLUTION / 60;
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

	public void setSpinning(boolean spinning) {
		this.spinning = spinning;
	}

	public boolean isSpinning() {
		return spinning;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	public boolean isShooting() {
		return shooting;
	}

	public void enable() {
		this.getPIDController().enable();
	}
	
	public void disableReset(){
		spinning = false;
		shooting = false;
		reset();
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
		setDefaultCommand(new AutoShooterControl());
	}

	protected double returnPIDInput() {
		return getPulseRate();
	}

	protected void usePIDOutput(double output) {
		setLeftMotorPower(output);
		setRightMotorPower(output);
	}
}