package org.usfirst.frc.team1675.robot.utilities;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class PowerDistribution {
	PowerDistributionPanel pdp;

	public PowerDistribution() {
		pdp = new PowerDistributionPanel();
	}

	// fill in the actual channels pls.
	// whichMotor is the CAN id of the motor that you want.
	public double getAugerCurrent() {
		return pdp.getCurrent(RobotMap.PDChannels.AUGER_MOTOR_POWER_CHANNEL);
	}

	public double getShooterCurrents(int whichMotor) {
		double shooterCurrent = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.LEFT_SHOOTER_MOTOR) {
			shooterCurrent = pdp.getCurrent(RobotMap.PDChannels.LEFT_SHOOTER_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_SHOOTER_MOTOR) {
			shooterCurrent = pdp.getCurrent(RobotMap.PDChannels.RIGHT_SHOOTER_POWER_CHANNEL);
		}
		return shooterCurrent;
	}

	public double getElevatorCurrents(int whichMotor) {
		double elevatorCurrent = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.LEFT_ELEVATOR_MOTOR) {
			elevatorCurrent = pdp.getCurrent(RobotMap.PDChannels.LEFT_ELEVATOR_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_ELEVATOR_MOTOR) {
			elevatorCurrent = pdp.getCurrent(RobotMap.PDChannels.RIGHT_ELEVATOR_POWER_CHANNEL);
		}
		return elevatorCurrent;
	}

	public double getIntakeCurrents(int whichMotor) {
		double intakeCurrent = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.INTAKE_INNER) {
			intakeCurrent = pdp.getCurrent(RobotMap.PDChannels.INTAKE_INNER_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.INTAKE_OUTER) {
			intakeCurrent = pdp.getCurrent(RobotMap.PDChannels.INTAKE_OUTER_POWER_CHANNEL);
		}
		return intakeCurrent;
	}

	public double getDriveMotorCurrents(int whichMotor) {
		double motorCurrent = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.LEFT_BACK_MOTOR) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.LEFT_BACK_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.LEFT_FRONT_MOTOR) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.LEFT_FRONT_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_BACK_MOTOR) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.RIGHT_BACK_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_FRONT_MOTOR) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.RIGHT_FRONT_POWER_CHANNEL);
		}
		return motorCurrent;
	}
}
