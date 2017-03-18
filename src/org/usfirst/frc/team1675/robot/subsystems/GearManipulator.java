package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearManipulator extends Subsystem {

	private DoubleSolenoid cylinderPosition;
	private CANTalon gearIntake;

	public GearManipulator() {

		gearIntake = new CANTalon(RobotMap.CANDeviceIDs.GEAR_MANIPULATOR);
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
		gearIntake.set(power);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
