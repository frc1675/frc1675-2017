package org.usfirst.frc.team1675.robot.utilities;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class PowerDistribution {
	PowerDistributionPanel pdp;

	public PowerDistribution() {
		pdp = new PowerDistributionPanel();
	}
	
	// id is the pd channel of the motor
	/*returns the current of the motor in Amperes for the channel specified
	 * channels range from 0 to 15, if you enter an invalid channel, this will return -1
	 */
	public double getMotorCurrent(int channel){
		if(channel >= 0 && channel < 16){
			return pdp.getCurrent(channel);
		}
		return -1;
	}
	
	/*
	 * returns the total current from all channels of the pdp in Amperes
	 */
	public double getTotalCurrent(){
		return pdp.getTotalCurrent();
	}
	
	/*
	 * returns the temperature of the PDP in degrees Celsius
	 */
	public double getTemperature(){
		return pdp.getTemperature();
	}
	
	/*returns the total energy drawn in Joules from all pdp channels
	 * 
	 */
	public double getEnergy(){
		return pdp.getTotalEnergy();
	}
	
	/*
	 * returns the total power in Watts from all pdp channels
	 */
	public double getPower(){
		return pdp.getTotalPower();
	}
	
	/*
	 * returns the input voltage in Volts for the pdp
	 */
	public double getVoltage(){
		return pdp.getVoltage();
	}
}
