package org.usfirst.frc.team1675.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class DPadButton extends Button{
	Joystick controller;
	Direction input;
	public DPadButton(Joystick joystick, Direction input){
		controller = joystick;
		this.input = input;
	}
	
	public static enum Direction{
		UP(0), RIGHT(90), DOWN(180), LEFT(270);
		
		int direction;
		private Direction(int direction){
			this.direction = direction;
		}
	}
	
	public boolean get(){
		int povValue = controller.getPOV();
		if (povValue == input.direction || povValue == (input.direction + 45) || povValue == (input.direction - 45)){
			return true;
		}
		return false;
	}
}
