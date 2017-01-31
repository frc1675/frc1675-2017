package org.usfirst.frc.team1675.robot.commands.shooter;
import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Fire extends Command {
	
	double setpoint;

    public Fire(double rpmSetpoint) {
    	setpoint = rpmSetpoint;
        requires(Robot.shooter);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	double speed = Robot.shooter.getRPM();
    	if(speed < setpoint){
    		Robot.shooter.setPower(1.0);
    	}else{
    		Robot.shooter.setPower(0.0);
    	}
    	SmartDashboard.putNumber("RPM:", speed);
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