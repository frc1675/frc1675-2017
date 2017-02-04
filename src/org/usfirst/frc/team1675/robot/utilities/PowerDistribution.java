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
	//whichMotor is the CAN id of the motor that you want.
	public double getAugerCurrent() {
		return pdp.getCurrent(RobotMap.PDChannels.AUGER_MOTOR_POWER_CHANNEL);
	}

	public double getShooterCurrents(double whichMotor) {
		double returnMotor = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.LEFT_SHOOTER_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.LEFT_SHOOTER_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_SHOOTER_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.RIGHT_SHOOTER_POWER_CHANNEL);
		}
		return returnMotor;

	}

	public double getElevatorCurrents(double whichMotor) {
		double returnMotor = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.LEFT_ELEVATOR_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.LEFT_ELEVATOR_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_ELEVATOR_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.RIGHT_ELEVATOR_POWER_CHANNEL);
		}
		return returnMotor;
	}

	public double getIntakeCurrents(double whichMotor) {
		double returnMotor = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.INTAKE_INNER) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.INTAKE_INNER_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.INTAKE_OUTER) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.INTAKE_OUTER_POWER_CHANNEL);
		}
		return returnMotor;
	}

	public double getDriveMotorCurrents(double whichMotor) {
		double returnMotor = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.LEFT_BACK_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.LEFT_BACK_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.LEFT_FRONT_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.LEFT_FRONT_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_BACK_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.RIGHT_BACK_POWER_CHANNEL);
		} else if (whichMotor == RobotMap.CANDeviceIDs.RIGHT_FRONT_MOTOR) {
			returnMotor = pdp.getCurrent(RobotMap.PDChannels.RIGHT_FRONT_POWER_CHANNEL);
		}
		return returnMotor;
	}
}
