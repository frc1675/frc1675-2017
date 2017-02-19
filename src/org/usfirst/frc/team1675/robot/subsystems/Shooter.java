package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon leftFireMotor;
	private CANTalon rightFireMotor;
	
	private Counter counter;

	public Shooter() {
		leftFireMotor = new CANTalon(RobotMap.CANDeviceIDs.LEFT_SHOOTER_MOTOR);
		rightFireMotor = new CANTalon(RobotMap.CANDeviceIDs.RIGHT_SHOOTER_MOTOR);
		
		counter = new Counter(RobotMap.DIOChannels.SHOOTER_COUNTER);
		counter.setDistancePerPulse(1);//sets a scaling value for getRate
		
		leftFireMotor.setInverted(false);
		rightFireMotor.setInverted(true);
	}

	public void setMotorPower(double power) {
		setLeftMotorPower(power);
		setRightMotorPower(power);
	}
	
	public void setLeftMotorPower(double power){
		power = scaledDeadzone(power);
		leftFireMotor.set(power);
	}
	
	public void setRightMotorPower(double power){
		power = scaledDeadzone(power);
		rightFireMotor.set(power);
	}

	public double getRPM() {
		return counter.getRate() * 60.0 / RobotMap.ShooterConstants.COUNTER_PULSES_PER_REVOLUTION;
//		60 comes from 60 seconds per minute
	}
	
	public double getPulseRate(){
		return counter.getRate();
	}
	
	public int getPulseCount(){
		return counter.get();
	}
	
	public double getCurrent(int motorChannel){
		return Robot.pdp.getShooterCurrents(motorChannel);
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power) * ((RobotMap.ShooterConstants.MAX_POWER - RobotMap.ShooterConstants.DEADZONE) * Math.abs(power)
				+ RobotMap.ShooterConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}