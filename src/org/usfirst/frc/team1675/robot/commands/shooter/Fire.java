package org.usfirst.frc.team1675.robot.commands.shooter;
import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Fire extends Command {
	
	double rpmSetpoint;

    public Fire(double rpmSetpoint) {
    	this.rpmSetpoint = rpmSetpoint;
        requires(Robot.shooter);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	double rpm = Robot.shooter.getRPM();
    	if(rpm < rpmSetpoint){
    		Robot.shooter.setPower(RobotMap.ShooterConstants.BANGBANG_HIGH);
    	}else{
    		Robot.shooter.setPower(RobotMap.ShooterConstants.BANGBANG_LOW);
    	}
    	SmartDashboard.putNumber("RPM:", rpm);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	Robot.shooter.setPower(0);
    }
    
    protected void interrupted() {
    	end();
    }
}