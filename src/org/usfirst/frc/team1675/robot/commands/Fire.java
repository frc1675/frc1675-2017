package org.usfirst.frc.team1675.robot.commands;
import org.usfirst.frc.team1675.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Fire extends Command {
	
	double setpoint;

    public Fire() {
    	setpoint = 300;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = Robot.shooter.getRPM();
    	if(speed < setpoint){
    		Robot.shooter.setPower(1.0);
    	}else{
    		Robot.shooter.setPower(0.0);
    	}
    	SmartDashboard.putNumber("RPM:", speed);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}