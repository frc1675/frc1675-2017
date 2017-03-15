package org.usfirst.frc.team1675.robot.commands.climber;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climbing extends Command {

	double power;
	double stallStartTime;

	public Climbing(double power) {
		requires(Robot.climber);

		this.power = power;
	}

	protected void initialize() {
		stallStartTime = timeSinceInitialized();
		SmartDashboard.putBoolean("Climber Running", true);
		SmartDashboard.putBoolean("Stopped from Current", false);

	}

	protected void execute() {
		Robot.climber.setPower(power);
		if (Robot.climber.getCurrent() < RobotMap.ClimberConstants.CURRENT_THRESHOLD) {
			stallStartTime = timeSinceInitialized();
		}
	}

	protected boolean isFinished() {
		if (timeSinceInitialized() - stallStartTime < RobotMap.ClimberConstants.MIN_STALL_TIME) {
			return false;
		} else {
			SmartDashboard.putBoolean("Stopped from Current", true);
			return true;
		}
	}

	protected void end() {
		Robot.climber.setPower(0);
		SmartDashboard.putBoolean("Climber Running", false);
	}

	protected void interrupted() {
		end();
	}
}
