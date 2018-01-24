package org.usfirst.frc.team1675.robot.commands.drive;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.filters.LinearDigitalFilter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class EncAvgDrive extends PIDCommand{
	PIDSource pst = new PIDSource() {
		PIDSourceType pidType;
		public void setPIDSourceType(PIDSourceType pidSource) {
			pidType=pidSource;
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			// TODO Auto-generated method stub
			return pidType;
		}

		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return (Robot.driveBase.getLeftEncoderValue()+Robot.driveBase.getRightEncoderValue())/2;
		}};

	double setpoint;
	double timeout;
	LinearDigitalFilter ldf = LinearDigitalFilter.movingAverage(pst, 10); ;

	/**
	 * 
	 * @param setpoint
	 *            distance to drive in inches
	 */
	public EncAvgDrive(double setpoint, double timeout) {
		super(RobotMap.DriveBaseConstants.P, RobotMap.DriveBaseConstants.I, RobotMap.DriveBaseConstants.D);
		requires(Robot.driveBase);
		this.setpoint = setpoint * RobotMap.DriveBaseConstants.TICKS_PER_INCH;
		this.timeout = timeout;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveBase.resetEncoder();
		this.getPIDController().reset();
		this.getPIDController().enable();
		this.getPIDController().setSetpoint(setpoint);
        this.getPIDController().setOutputRange(-1.0, 1.0);
        this.setTimeout(timeout);
		this.getPIDController().setAbsoluteTolerance(RobotMap.DriveBaseConstants.TOLERANCE);
		//this.getPIDController().setToleranceBuffer(RobotMap.DriveBaseConstants.BUFFER);
	}

	protected void execute() {
	}
	public boolean averageOnTarget() {
		if(ldf.pidGet()>=setpoint - RobotMap.DriveBaseConstants.TOLERANCE) {
			if(ldf.pidGet()<=setpoint + RobotMap.DriveBaseConstants.TOLERANCE) {
				return true;
			}
		}
		return false;
	}

	protected boolean isFinished() {
		if(averageOnTarget()|| this.isTimedOut()){
			SmartDashboard.putNumber("finalLeft", Robot.driveBase.getLeftEncoderValue());
			return true;
		}else return false;
	}
	
	

	protected void end() {
		this.getPIDController().disable();
		Robot.driveBase.setMotorPower(0);
	}

	protected void interrupted() {
		end();
	}

	protected double returnPIDInput() {
		double encodervalue = (Robot.driveBase.getLeftEncoderValue()+Robot.driveBase.getRightEncoderValue())/2;
		SmartDashboard.putNumber("encoder value", encodervalue);
		return encodervalue;
	}

	protected void usePIDOutput(double output) {
		Robot.driveBase.setMotorPower(output);
		SmartDashboard.putNumber("Set Motor Power", output);
	}
	
}
 