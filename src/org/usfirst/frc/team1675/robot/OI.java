package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driverController = new Joystick(XBoxControllerMap.driverControllerPort);
	private JoystickButton driverAButton = new JoystickButton(driverController,XBoxControllerMap.A_BUTTON);
	private JoystickButton driverBButton = new JoystickButton(driverController,XBoxControllerMap.B_BUTTON);
	private JoystickButton driverXButton = new JoystickButton(driverController,XBoxControllerMap.X_BUTTON);
	private JoystickButton driverYButton = new JoystickButton(driverController,XBoxControllerMap.Y_BUTTON);
	private JoystickButton driverRightBumper = new JoystickButton(driverController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton driverLeftBumper = new JoystickButton(driverController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
	//private TriggerButton driverRightTrigger = new TriggerButton(driverController,XBoxControllerMap.RIGHT_TRIGGER_BUTTON);
	//private TriggerButton driverLeftBumper = new TriggerButton(driverController,XBoxControllerMap.LEFT_TRIGGER_BUTTON);
	private Joystick operatorController = new Joystick(XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorAButton = new JoystickButton(operatorController,XBoxControllerMap.A_BUTTON);
	private JoystickButton operatorBButton = new JoystickButton(operatorController,XBoxControllerMap.B_BUTTON);
	private JoystickButton operatorXButton = new JoystickButton(operatorController,XBoxControllerMap.X_BUTTON);
	private JoystickButton operatorYButton = new JoystickButton(operatorController,XBoxControllerMap.Y_BUTTON);
	private JoystickButton operatorRightBumper = new JoystickButton(operatorController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton operatorLeftBumper = new JoystickButton(operatorController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
	
	public double GetLeftXAxisDRIVER(){
		double LeftXDriver = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return LeftXDriver;
	}
	public double GetLeftYAxisDRIVER(){
		double LeftYDriver = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return LeftYDriver;
	}
	public double GetRightXAxisDRIVER(){
		double RightXDriver = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return RightXDriver;
	}
	public double GetRightYAxisDRIVER(){
		double RightYDriver = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return RightYDriver;
	}
	public double GetLeftXAxisOPER(){
		double LeftXOper = operatorController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return LeftXOper;
	}
	public double GetLeftYAxisOper(){
		double LeftYOper = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return LeftYOper;
	}
	public double GetRightXAxisOper(){
		double RightXOper = operatorController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return RightXOper;
	}
	public double GetRightYAxisOper(){
		double RightYOper = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return RightYOper;
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
