package org.usfirst.frc.team1675.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class DPadButton extends Button{
	int direction;
	Joystick controller;
	public DPadButton(Joystick joystick, Direction input){
		controller = joystick;
		switch(input){
		case UP:
			direction = 0;
			break;
		case RIGHT:
			direction = 90;
			break;
		case DOWN:
			direction = 180;
			break;
		case LEFT:
			direction = 270;
			break;
		default:
			break;
		}
	}
	
	public static enum Direction{
		UP, RIGHT, DOWN, LEFT
	}
	
	public boolean get(){
		int povValue = controller.getPOV();
		if (povValue == direction || povValue == (direction + 45) || povValue == (direction + 315)%360){
			return true;
		}
		return false;
	}
}
