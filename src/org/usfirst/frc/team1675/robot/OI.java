package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.Elevate;

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
	private JoystickButton driverStartButton = new JoystickButton(driverController, XBoxControllerMap.START_BUTTON);
	private JoystickButton driverBackButton = new JoystickButton(driverController, XBoxControllerMap.BACK_BUTTON);
	private JoystickButton driverRightJoystickButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
	private JoystickButton driverLeftJoystickButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
	private Joystick operatorController = new Joystick(XBoxControllerMap.operatorControllerPort);
	private JoystickButton operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
	private JoystickButton operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
	private JoystickButton operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
	private JoystickButton operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
	private JoystickButton operatorRightBumper = new JoystickButton(operatorController,	XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton operatorLeftBumper = new JoystickButton(operatorController,	XBoxControllerMap.LEFT_BUMPER_BUTTON);
	private JoystickButton operatorStartButton = new JoystickButton(operatorController, XBoxControllerMap.START_BUTTON);
	private JoystickButton operatorBackButton = new JoystickButton(operatorController, XBoxControllerMap.BACK_BUTTON);
	private JoystickButton operatorRightJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
	private JoystickButton operatorLeftJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
	
	public OI(){
		operatorAButton.whileHeld(new Elevate(1));
		operatorYButton.whileHeld(new Elevate(-1));
	}

	public double getDriverLeftXAxis() {
		return checkForDeadzone(driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS));
	}

	public double getDriverLeftYAxis() {
		return -checkForDeadzone(driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS));
	}

	public double getDriverRightXAxis() {
		return checkForDeadzone(driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS));
	}

	public double getDriverRightYAxis() {
		return -checkForDeadzone(driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS));
	}

	public double getDriverLeftTriggerAxis() {
		return checkForDeadzone(driverController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS));
	}

	public double getDriverRightTriggerAxis() {
		return checkForDeadzone(driverController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS));
	}

	public double getOperatorLeftXAxis() {
		return checkForDeadzone(operatorController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS));
	}

	public double getOperatorLeftYAxis() {
		return -checkForDeadzone(operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS));
	}

	public double getOperatorRightXAxis() {
		return checkForDeadzone(operatorController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS));
	}

	public double getOperatorRightYAxis() {
		return -checkForDeadzone(operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS));
	}

	public double getOperatorLeftTriggerAxis() {
		return checkForDeadzone(operatorController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS));
	}

	public double getOperatorRightTriggerAxis() {
		return checkForDeadzone(operatorController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS));
	}
	public double checkForDeadzone(double vector){
		if(Math.abs(vector) < RobotMap.DriverConstants.CONTROLLER_DEADZONE){
			return 0;
		}
		return Math.signum(vector) * (Math.abs(vector) - RobotMap.DriverConstants.CONTROLLER_DEADZONE)/(1 - RobotMap.DriverConstants.CONTROLLER_DEADZONE);
	}
}
