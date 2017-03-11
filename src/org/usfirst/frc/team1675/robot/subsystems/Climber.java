package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
	private CANTalon climberTalon;

	public Climber() {
		climberTalon = new CANTalon(RobotMap.CANDeviceIDs.CLIMBER);

	}

	public void setPower(double power) {
		climberTalon.set(power);

	}
	
	public double getCurrent(){
		SmartDashboard.putNumber("Climber Current", Robot.pdp.getClimberCurrent());
				return Robot.pdp.getClimberCurrent();
	}

	public void initDefaultCommand() {

	}
}
