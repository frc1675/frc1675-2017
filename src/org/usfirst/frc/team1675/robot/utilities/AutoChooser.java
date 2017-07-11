package org.usfirst.frc.team1675.robot.utilities;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.auto.CenterEscapeLeft;
import org.usfirst.frc.team1675.robot.commands.auto.CenterEscapeRight;
import org.usfirst.frc.team1675.robot.commands.auto.GearCenter;
import org.usfirst.frc.team1675.robot.commands.auto.GearLeftBoiler;
import org.usfirst.frc.team1675.robot.commands.auto.GearLeftFeeder;
import org.usfirst.frc.team1675.robot.commands.auto.GearRightBoiler;
import org.usfirst.frc.team1675.robot.commands.auto.GearRightFeeder;
import org.usfirst.frc.team1675.robot.commands.auto.LeftEscapeLeft;
import org.usfirst.frc.team1675.robot.commands.auto.LeftEscapeRight;
import org.usfirst.frc.team1675.robot.commands.auto.RightEscapeLeft;
import org.usfirst.frc.team1675.robot.commands.auto.RightEscapeRight;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {
	private DigitalInput centerVsSideSwitch;
	private DigitalInput sideChoiceSwitch;

	private boolean sideAuto;
	private boolean rightOrCenterAuto;

	public AutoChooser() {
		centerVsSideSwitch = new DigitalInput(RobotMap.DIOChannels.AUTO_SIDE_VS_CENTER);
		sideChoiceSwitch = new DigitalInput(RobotMap.DIOChannels.AUTO_SIDE_CHOICE_OR_CENTER_VS_NOTHING);
		sideAuto = centerVsSideSwitch.get();
		rightOrCenterAuto = sideChoiceSwitch.get();
	}

	public CommandGroup generateAuto() {
		CommandGroup auto = new CommandGroup();

		if (sideAuto) {
			if (rightOrCenterAuto) {
				auto.addSequential(new GearRightFeeder());
				auto.addSequential(new RightEscapeRight());
			} else {
				auto.addSequential(new GearLeftFeeder());
				auto.addSequential(new LeftEscapeLeft());
			}
		} else if (rightOrCenterAuto) {
			auto.addSequential(new GearCenter());
		}
		return auto;

	}
}
