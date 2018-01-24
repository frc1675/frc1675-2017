package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearManipulator extends Subsystem {

	private DoubleSolenoid cylinderPosition;
	private TalonSRX gearIntake;

	public GearManipulator() {

		gearIntake = new TalonSRX(RobotMap.CANDeviceIDs.GEAR_MANIPULATOR);
		cylinderPosition = new DoubleSolenoid(RobotMap.SolenoidChannels.DEPLOY_LEFT_EXTEND,
				RobotMap.SolenoidChannels.DEPLOY_LEFT_RETRACT);

	}

	public void deployGearManipulator() {
		cylinderPosition.set(DoubleSolenoid.Value.kForward);
	}

	public void retractGearManipulator() {
		cylinderPosition.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopSolenoids() {
		cylinderPosition.set(DoubleSolenoid.Value.kOff);
	}

	public void runGearManipulator(double power) {
		gearIntake.set(ControlMode.PercentOutput,power);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
