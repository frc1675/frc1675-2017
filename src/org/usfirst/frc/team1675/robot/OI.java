package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.climber.Climbing;
import org.usfirst.frc.team1675.robot.commands.drive.ShiftHigh;
import org.usfirst.frc.team1675.robot.commands.drive.ShiftLow;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.AutoScore;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.GearManipulating;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.GearManipulatorDown;
import org.usfirst.frc.team1675.robot.commands.gearManipulator.GearManipulatorUp;
import org.usfirst.frc.team1675.robot.utils.DPadButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick driverController = new Joystick(XBoxControllerMap.DRIVER_CONTROLLER_PORT);
	private JoystickButton driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
	private JoystickButton driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
	private JoystickButton driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
	private JoystickButton driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
	private JoystickButton driverRightBumper = new JoystickButton(driverController,
			XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton driverLeftBumper = new JoystickButton(driverController,
			XBoxControllerMap.LEFT_BUMPER_BUTTON);
	private JoystickButton driverStartButton = new JoystickButton(driverController, XBoxControllerMap.START_BUTTON);
	private JoystickButton driverBackButton = new JoystickButton(driverController, XBoxControllerMap.BACK_BUTTON);
	private JoystickButton driverRightJoystickButton = new JoystickButton(driverController,
			XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
	private JoystickButton driverLeftJoystickButton = new JoystickButton(driverController,
			XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
	private DPadButton driverUpDPadButton = new DPadButton(driverController, DPadButton.Direction.UP);
	private DPadButton driverRightDPadButton = new DPadButton(driverController, DPadButton.Direction.RIGHT);
	private DPadButton driverDownButton = new DPadButton(driverController, DPadButton.Direction.DOWN);
	private DPadButton driverLeftDPadButton = new DPadButton(driverController, DPadButton.Direction.LEFT);

	private Joystick operatorController = new Joystick(XBoxControllerMap.OPERATOR_CONTROLLER_PORT);
	private JoystickButton operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
	private JoystickButton operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
	private JoystickButton operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
	private JoystickButton operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
	private JoystickButton operatorRightBumper = new JoystickButton(operatorController,
			XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton operatorLeftBumper = new JoystickButton(operatorController,
			XBoxControllerMap.LEFT_BUMPER_BUTTON);
	private JoystickButton operatorStartButton = new JoystickButton(operatorController, XBoxControllerMap.START_BUTTON);
	private JoystickButton operatorBackButton = new JoystickButton(operatorController, XBoxControllerMap.BACK_BUTTON);

	private JoystickButton operatorRightJoystickButton = new JoystickButton(operatorController,
			XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
	private JoystickButton operatorLeftJoystickButton = new JoystickButton(operatorController,
			XBoxControllerMap.LEFT_JOYSTICK_BUTTON);

	private DPadButton operatorUpDPadButton = new DPadButton(operatorController, DPadButton.Direction.UP);
	private DPadButton operatorRightDPadButton = new DPadButton(operatorController, DPadButton.Direction.RIGHT);
	private DPadButton operatorDownButton = new DPadButton(operatorController, DPadButton.Direction.DOWN);
	private DPadButton operatorLeftDPadButton = new DPadButton(operatorController, DPadButton.Direction.LEFT);


	public OI() {
		
		operatorRightBumper.whenPressed(new Climbing(RobotMap.ClimberConstants.CLIMBER_POWER));
		operatorRightBumper.whenReleased(new Climbing(RobotMap.ClimberConstants.CLIMBER_STOPPED));
	

		operatorLeftBumper.whenPressed(new AutoScore(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT));
		
		
		operatorYButton.whenPressed(new GearManipulating(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_OUT));
		operatorYButton.whenReleased(new GearManipulating(0));

		operatorAButton.whenPressed(new GearManipulatorDown());
		
		operatorXButton.whenPressed(new GearManipulating(RobotMap.GearManipulatorConstants.GEAR_SPINNER_POWER_IN));
		operatorXButton.whenReleased(new GearManipulating(0));

		
		operatorBButton.whenPressed(new GearManipulatorUp());
		
		driverRightBumper.whenPressed(new ShiftHigh());
		driverRightBumper.whenReleased(new ShiftLow());
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

	public double checkForDeadzone(double vector) {
		if (Math.abs(vector) < XBoxControllerMap.DEAD_ZONE) {
			return 0;
		}
		return Math.signum(vector) * (Math.abs(vector) - XBoxControllerMap.DEAD_ZONE)
				/ (1 - XBoxControllerMap.DEAD_ZONE);
	}
}
