package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class TurnOnGyro extends PIDCommand {
	static final double P = .03;
	static final double I = .0;
	static final double D = .03;
	static final double TOLERANCE = 0.5;
	static final int BUFFER = 10;
	double setpoint;
	double initialDegrees;
	/**
	 * 
	 * @param setpoint angle to turn in degrees
	 */
	public TurnOnGyro(double setpoint,double timeout) {
		super(P, I, D);
		requires(Robot.driveBase);
		this.setpoint = setpoint;
	}

	protected void initialize() {
		SmartDashboard.putString("Turn command", "Started");
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setOutputRange(-1.0, 1.0);
		initialDegrees = Robot.driveBase.getAngle();
    	this.getPIDController().setSetpoint((initialDegrees + setpoint));
		this.getPIDController().setAbsoluteTolerance(TOLERANCE);
		this.getPIDController().setToleranceBuffer(BUFFER);
		this.setTimeout(20);
        this.getPIDController().setContinuous(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if(this.getPIDController().onTarget() || this.isTimedOut()){
			SmartDashboard.putNumber("finalAngle", Robot.driveBase.getAngle());
			return true;
		}else return false;
	}

	protected void end() {
		this.getPIDController().disable();
		SmartDashboard.putString("Turn command", "Ended");
		Robot.driveBase.setLeftMotors(0);
		Robot.driveBase.setRightMotors(0);
	}

	protected void interrupted() {
		end();
	}

	protected double returnPIDInput() {
		return Robot.driveBase.getAngle();
	}

	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("GyroPIDoutput", output);
		SmartDashboard.putNumber("GyroPIDError", this.getPIDController().getError());
		SmartDashboard.putNumber("GyroPIDAngle", Robot.driveBase.getAngle());
		Robot.driveBase.setLeftMotors(output);
		Robot.driveBase.setRightMotors(-output);
	}
}