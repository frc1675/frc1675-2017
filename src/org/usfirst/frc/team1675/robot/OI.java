package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.shooter.Fire;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick driverController = new Joystick(XBoxControllerMap.driverControllerPort);
	private JoystickButton driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
	private JoystickButton driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
	private JoystickButton driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
	private JoystickButton driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
	private JoystickButton driverRightBumper = new JoystickButton(driverController,	XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton driverLeftBumper = new JoystickButton(driverController,	XBoxControllerMap.LEFT_BUMPER_BUTTON);
	private JoystickButton driverLeftJoystick = new JoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
	private JoystickButton driverRightJoystick = new JoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
	// private TriggerButton driverRightTrigger = new
	// TriggerButton(driverController,XBoxControllerMap.RIGHT_TRIGGER_BUTTON);
	// private TriggerButton driverLeftBumper = new
	// TriggerButton(driverController,XBoxControllerMap.LEFT_TRIGGER_BUTTON);
	private Joystick operatorController = new Joystick(XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
	private JoystickButton operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
	private JoystickButton operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
	private JoystickButton operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
	private JoystickButton operatorRightBumper = new JoystickButton(operatorController,	XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton operatorLeftBumper = new JoystickButton(operatorController,	XBoxControllerMap.LEFT_BUMPER_BUTTON);
	
	public OI(){
		driverAButton.whileHeld(new Fire(300));
	}
	
	public double getLeftXAxisDriver() {
		double leftXDriver = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return leftXDriver;
	}

	public double getLeftYAxisDriver() {
		double leftYDriver = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return leftYDriver;
	}

	public double getRightXAxisDriver() {
		double rightXDriver = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return rightXDriver;
	}

	public double getRightYAxisDriver() {
		double rightYDriver = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return rightYDriver;

	}

	public double getLeftTriggerAxisDriver() {
		double leftTriggerDriver = driverController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS);
		return leftTriggerDriver;
	}

	public double getRightTriggerAxisDriver() {
		double rightTriggerDriver = driverController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS);
		return rightTriggerDriver;
	}

	public double getLeftXAxisOperator() {
		double leftXOperator = operatorController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return leftXOperator;
	}

	public double getLeftYAxisOperator() {
		double leftYOperator = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return leftYOperator;
	}

	public double getRightXAxisOperator() {
		double rightXOperator = operatorController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return rightXOperator;
	}

	public double getRightYAxisOperator() {
		double rightYOperator = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return rightYOperator;
	}

	public double getLeftTriggerAxisOperator() {
		double leftTriggerOperator = operatorController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS);
		return leftTriggerOperator;
	}

	public double getRightTriggerAxisOperator() {
		double rightTriggerOperator = operatorController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS);
		return rightTriggerOperator;
	}
}
