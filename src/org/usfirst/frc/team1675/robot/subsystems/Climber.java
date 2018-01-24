package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
	private TalonSRX climberTalon;

	public Climber() {
		climberTalon = new TalonSRX(RobotMap.CANDeviceIDs.CLIMBER);

	}

	public void setPower(double power) {
		climberTalon.set(ControlMode.PercentOutput,power);

	}
	
	public double getCurrent(){
		SmartDashboard.putNumber("Climber Current", Robot.pdp.getClimberCurrent());
				return Robot.pdp.getClimberCurrent();
	}

	public void initDefaultCommand() {

	}
}
