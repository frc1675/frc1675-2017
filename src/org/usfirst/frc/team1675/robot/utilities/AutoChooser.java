package org.usfirst.frc.team1675.robot.utilities;

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

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {

	private SendableChooser liftChooser;
	private SendableChooser startChooser;
	private SendableChooser afterScoreChooser;

	public enum LiftPosition {
		LEFT, CENTER, RIGHT
	}

	public enum StartPosition {
		BOILER, CENTER, FEEDER
	}

	public enum AfterScoreChoice {
		NOTHING, ESCAPE_LEFT, ESCAPE_RIGHT
	}

	public AutoChooser() {
		// make and fill in choosers with enums

		// put choosers on smart dashboard
		liftChooser = new SendableChooser();
		startChooser = new SendableChooser();
		afterScoreChooser = new SendableChooser();

		liftChooser.addObject("Left Lift", LiftPosition.LEFT);
		liftChooser.addObject("Center Lift", LiftPosition.CENTER);
		liftChooser.addObject("Right Lift", LiftPosition.RIGHT);

		startChooser.addObject("Near Boiler", StartPosition.BOILER);
		startChooser.addObject("Center", StartPosition.CENTER);
		startChooser.addObject("Near Feeder", StartPosition.FEEDER);

		afterScoreChooser.addObject("Escape Left", AfterScoreChoice.ESCAPE_LEFT);
		afterScoreChooser.addObject("Nothing", AfterScoreChoice.NOTHING);
		afterScoreChooser.addObject("Escape Right", AfterScoreChoice.ESCAPE_RIGHT);

		SmartDashboard.putData("Lift", liftChooser);
		SmartDashboard.putData("Start", startChooser);
		SmartDashboard.putData("After Score", afterScoreChooser);
	}

	public CommandGroup generateAuto() {
		CommandGroup auto = new CommandGroup();

		LiftPosition selectedLift = (LiftPosition) liftChooser.getSelected();
		StartPosition selectedStart = (StartPosition) startChooser.getSelected();

		switch (selectedLift) {
		case LEFT:
			switch (selectedStart) {
			case BOILER:
				auto.addSequential(new GearLeftBoiler());
				break;
			case FEEDER:
				auto.addSequential(new GearLeftFeeder());
				break;
			default:
				auto.addSequential(new GearCenter());
				break;
			}
			break;
		case CENTER:
			auto.addSequential(new GearCenter());
			break;
		case RIGHT:
			switch (selectedStart) {
			case BOILER:
				auto.addSequential(new GearRightBoiler());

				break;
			case FEEDER:
				auto.addSequential(new GearRightFeeder());

				break;
			default:
				auto.addSequential(new GearCenter());
				break;
			}
			break;
		default:
			// shouldnt be possible, do nothing
			return auto;
		}

		AfterScoreChoice selectedAfterScore = (AfterScoreChoice) afterScoreChooser.getSelected();

		switch (selectedAfterScore) {
		case ESCAPE_LEFT:
			switch (selectedLift) {
			case LEFT:
				auto.addSequential(new LeftEscapeLeft());
				break;
			case CENTER:
				auto.addSequential(new CenterEscapeLeft());
				break;
			case RIGHT:
				auto.addSequential(new RightEscapeLeft());
				break;
			}
			break;
		case ESCAPE_RIGHT:
			switch (selectedLift) {
			case LEFT:
				auto.addSequential(new LeftEscapeRight());
				break;
			case CENTER:
				auto.addSequential(new CenterEscapeRight());
				break;
			case RIGHT:
				auto.addSequential(new RightEscapeRight());
				break;
			}
			break;
		case NOTHING:
			break;
		}

		return auto;
	}

}
