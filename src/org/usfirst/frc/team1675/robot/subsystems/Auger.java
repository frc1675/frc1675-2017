package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Auger extends Subsystem {
	//this is a constructor

	
	private CANTalon augerController = new CANTalon(RobotMap.CANDeviceIDs.AUGER_MOTOR);

	public void setAugerPower (double power){
		augerController.set(power);
		
	}
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

