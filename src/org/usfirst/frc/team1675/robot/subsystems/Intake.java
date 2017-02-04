package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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

	public void initDefaultCommand() {
	}

	public void deployIntake() {
		deployLeft.set(DoubleSolenoid.Value.kForward);
		deployRight.set(DoubleSolenoid.Value.kForward);
	}

	public void retractIntake() {
		deployLeft.set(DoubleSolenoid.Value.kReverse);
		deployRight.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopSolenoids() {
		deployLeft.set(DoubleSolenoid.Value.kOff);
		deployRight.set(DoubleSolenoid.Value.kOff);
	}

	public void runIntake(double power) {
		power = scaledDeadzone(power);
		intakeInner.set(power);
		intakeOuter.set(power);
	}
	public double getCurrent(int motorChannel){
		return Robot.pdp.getIntakeCurrents(motorChannel);
	}

	private double scaledDeadzone(double power) {
		return Math.signum(power)
				* ((RobotMap.IntakeConstants.MAX_POWER - RobotMap.IntakeConstants.DEADZONE) * Math.abs(power)
						+ RobotMap.IntakeConstants.DEADZONE);
	}
}