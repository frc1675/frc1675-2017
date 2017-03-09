package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.ElevateAndSpinAuger;
import org.usfirst.frc.team1675.robot.commands.drive.ShiftHigh;
import org.usfirst.frc.team1675.robot.commands.drive.ShiftLow;
import org.usfirst.frc.team1675.robot.commands.intake.IntakeDeploy;
import org.usfirst.frc.team1675.robot.commands.intake.IntakeFuel;
import org.usfirst.frc.team1675.robot.commands.intake.IntakeRetract;
import org.usfirst.frc.team1675.robot.commands.shooter.PIDShooter;

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
	private JoystickButton driverRightBumper = new JoystickButton(driverController,	XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton driverLeftBumper = new JoystickButton(driverController,	XBoxControllerMap.LEFT_BUMPER_BUTTON);
	private JoystickButton driverStartButton = new JoystickButton(driverController, XBoxControllerMap.START_BUTTON);
	private JoystickButton driverBackButton = new JoystickButton(driverController, XBoxControllerMap.BACK_BUTTON);
	private JoystickButton driverRightJoystickButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
	private JoystickButton driverLeftJoystickButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
	private Joystick operatorController = new Joystick(XBoxControllerMap.OPERATOR_CONTROLLER_PORT);
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
		operatorYButton.toggleWhenPressed(new PIDShooter(RobotMap.ShooterConstants.SETPOINT_RPM));
		operatorXButton.toggleWhenPressed(new PIDShooter(RobotMap.ShooterConstants.SETPOINT_RPM - 50));
		operatorBButton.toggleWhenPressed(new PIDShooter(RobotMap.ShooterConstants.SETPOINT_RPM + 50));
		//operatorLeftBumper.whileHeld(new IntakeFuel(RobotMap.IntakeConstants.INTAKE_POWER));
//		operatorRightBumper.whileHeld(new IntakeFuel(RobotMap.IntakeConstants.OUTTAKE_POWER));
		operatorAButton.whileHeld(new ElevateAndSpinAuger(RobotMap.AugerConstants.FORWARDS_POWER, RobotMap.ElevatorConstants.FORWARDS_POWER));
		
		//operatorRightBumper.whenPressed(new IntakeDeploy());
		//operatorStartButton.whenPressed(new IntakeRetract());
		
		driverRightBumper.whenPressed(new ShiftLow());
		driverRightBumper.whenReleased(new ShiftHigh());
//		driverXButton.whileHeld(new ShootingProcedure(RobotMap.ElevatorConstants.FORWARDS_POWER,RobotMap.ShooterConstants.SETPOINT_RPM));
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
		if(Math.abs(vector) < XBoxControllerMap.DEAD_ZONE){
			return 0;
		}
		return Math.signum(vector) * (Math.abs(vector) - XBoxControllerMap.DEAD_ZONE)/(1 - XBoxControllerMap.DEAD_ZONE);
	}
}
