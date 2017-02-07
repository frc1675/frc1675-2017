package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon leftFireMotor;
	private CANTalon rightFireMotor; 

	public Shooter() {
		leftFireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_LEFT);
		rightFireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_RIGHT);
		
		leftFireMotor.reverseSensor(true);//might not apply to our robot
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

	public double getMotorRPM() {
		return leftFireMotor.getSpeed() * 600.0 / RobotMap.ShooterConstants.ENCODER_TICKS_PER_REVOLUTION;
		//600 comes from 60 seconds per minute times times 10 tenths of a second per second
	}
	
	public double getLeftCurrent(){
		return Robot.pdp.getMotorCurrent(RobotMap.PDChannels.SHOOTER_LEFT);
	}
	
	public double getRightCurrent(){
		return Robot.pdp.getMotorCurrent(RobotMap.PDChannels.SHOOTER_RIGHT);
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power) * ((RobotMap.ShooterConstants.MAX_POWER - RobotMap.ShooterConstants.DEADZONE) * Math.abs(power)
				+ RobotMap.ShooterConstants.DEADZONE);
	}

	public void initDefaultCommand() {
	}
}