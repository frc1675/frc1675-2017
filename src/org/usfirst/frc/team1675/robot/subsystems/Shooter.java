package org.usfirst.frc.team1675.robot.subsystems;
import org.usfirst.frc.team1675.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon fireMotor;
	
	public Shooter(){
		fireMotor = new CANTalon(RobotMap.CANDeviceIDs.SHOOTER_MOTOR);
	}
	public void setPower(double power){
		power = motorDeadzone(power);
		fireMotor.set(power);
	}
	public double getSpeed(){
		return fireMotor.getSpeed();
	}
	public double getRPM(){
		return fireMotor.getEncVelocity() / RobotMap.MotorConstants.ENCODER_TICKS_PER_ROTATION;
	}
	private double motorDeadzone(double power){
		if(power == 0){
			return 0;
		}else{
			return Math.signum(power) * ((1 - RobotMap.MotorConstants.SHOOTER_DEADZONE) * Math.abs(power) + RobotMap.MotorConstants.SHOOTER_DEADZONE);
		}
	}
    public void initDefaultCommand() {
    }
}