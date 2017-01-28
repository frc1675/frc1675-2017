package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	CANTalon intakeInner;
	CANTalon intakeOuter;

	DoubleSolenoid deployLeft;
	DoubleSolenoid deployRight;

	public Intake() {

		intakeInner = new CANTalon(RobotMap.CANDeviceIDs.INTAKE_INNER);
		intakeOuter = new CANTalon(RobotMap.CANDeviceIDs.INTAKE_OUTER);

		deployLeft = new DoubleSolenoid(RobotMap.SolenoidChannels.DEPLOY_LEFT_EXTEND,
				RobotMap.SolenoidChannels.DEPLOY_LEFT_RETRACT);
		deployRight = new DoubleSolenoid(RobotMap.SolenoidChannels.DEPLOY_RIGHT_EXTEND,
				RobotMap.SolenoidChannels.DEPLOY_RIGHT_RETRACT);

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void deployIntake() {
		deployLeft.set(DoubleSolenoid.Value.kForward);
		deployRight.set(DoubleSolenoid.Value.kForward);
	}

	public void undeployIntake() {
		deployLeft.set(DoubleSolenoid.Value.kReverse);
		deployRight.set(DoubleSolenoid.Value.kReverse);
	}

	public void haltIntakeDeploy() {
		deployLeft.set(DoubleSolenoid.Value.kOff);
		deployRight.set(DoubleSolenoid.Value.kOff);
	}

	public void runIntake(double power) {
		power = motorDeadzone(power);
		intakeInner.set(power);
		intakeOuter.set(power);
	}

	private double motorDeadzone(double power) {
		return Math.signum(power) * ((1 - RobotMap.IntakeConstants.INTAKE_DEADZONE) * Math.abs(power)
				+ RobotMap.IntakeConstants.INTAKE_DEADZONE);
	}

}
