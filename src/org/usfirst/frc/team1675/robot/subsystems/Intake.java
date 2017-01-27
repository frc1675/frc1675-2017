package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	CANTalon intakeInner;
	CANTalon intakeOuter;

	Solenoid deployLeft;
	Solenoid deployRight;

	public Intake() {

		intakeInner = new CANTalon(RobotMap.CANDeviceIDs.INTAKE_INNER);
		intakeOuter = new CANTalon(RobotMap.CANDeviceIDs.INTAKE_OUTER);

		deployLeft = new Solenoid(RobotMap.SolenoidChannels.DEPLOY_LEFT);
		deployRight = new Solenoid(RobotMap.SolenoidChannels.DEPLOY_RIGHT);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void deployIntake() {
		deployLeft.set(true);
		deployRight.set(true);
	}

	public void undeployIntake() {
		deployLeft.set(false);
		deployRight.set(false);
	}

	public void runIntake(double power) {
		power = intakeDeadzone(power);
		intakeInner.set(power);
		intakeOuter.set(power);
	}	

	private double intakeDeadzone(double power) {
		if (power == 0) {
			return 0;
		} else {
			return Math.signum(power) * ((1 - RobotMap.IntakeConstants.INTAKE_DEADZONE) * Math.abs(power)
					+ RobotMap.IntakeConstants.INTAKE_DEADZONE);
		}
	}

}
