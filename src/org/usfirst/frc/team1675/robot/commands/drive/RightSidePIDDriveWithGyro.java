package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

public class RightSidePIDDriveWithGyro extends RightSidePIDDrive {

	public RightSidePIDDriveWithGyro(double setpoint, double timeout) {
		super(setpoint, timeout);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void initialize(){
		Robot.driveBase.resetGyro();
		super.initialize();
	}
	
	@Override
	protected void usePIDOutput(double output){
		output += Robot.driveBase.getAngle() * RobotMap.DriveBaseConstants.GYRO_MODIFIER;
		if(Math.abs(output) > 1)
			output = Math.signum(output);
		super.usePIDOutput(output);
	}

}
