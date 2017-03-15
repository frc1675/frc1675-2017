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
	public double getClimberCurrent(){
			return pdp.getCurrent(RobotMap.PDChannels.CLIMBER);
	}
	
	

	public double getIntakeCurrents(int whichMotor) {
		double intakeCurrent = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.INTAKE_INNER) {
			intakeCurrent = pdp.getCurrent(RobotMap.PDChannels.INTAKE_INNER);
		} else if (whichMotor == RobotMap.CANDeviceIDs.INTAKE_OUTER) {
			intakeCurrent = pdp.getCurrent(RobotMap.PDChannels.INTAKE_OUTER);
		}
		return intakeCurrent;
	}

	public double getDriveMotorCurrents(int whichMotor) {
		double motorCurrent = 0;
		if (whichMotor == RobotMap.CANDeviceIDs.DRIVE_LEFT_BACK) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.DRIVE_LEFT_BACK);
		} else if (whichMotor == RobotMap.CANDeviceIDs.DRIVE_LEFT_FRONT) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.DRIVE_LEFT_FRONT);
		} else if (whichMotor == RobotMap.CANDeviceIDs.DRIVE_RIGHT_BACK) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.DRIVE_RIGHT_BACK);
		} else if (whichMotor == RobotMap.CANDeviceIDs.DRIVE_RIGHT_FRONT) {
			motorCurrent = pdp.getCurrent(RobotMap.PDChannels.DRIVE_RIGHT_FRONT);
		}
		return motorCurrent;
	}
	
	public double getMotorCurrent(int pdChannel){
		if(pdChannel >= 0 && pdChannel <= 15){
			return pdp.getCurrent(pdChannel);
		}
		return -1;
	}
}
