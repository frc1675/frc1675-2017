			package org.usfirst.frc.team1675.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static class PWMChannels {
	}

	public static class CANDeviceIDs {
		public static final int DRIVE_LEFT_FRONT = 1;
		public static final int DRIVE_LEFT_BACK = 2;
		public static final int DRIVE_RIGHT_FRONT = 3;
		public static final int DRIVE_RIGHT_BACK = 4;
		public static final int INTAKE_INNER = 7;
		public static final int INTAKE_OUTER = 6;
		public static final int CLIMBER = 5;
		public static final int GEAR_MANIPULATOR = 6;
	}

	public static class PDChannels {
		public static final int DRIVE_LEFT_FRONT = 1;
		public static final int DRIVE_LEFT_BACK = 0;
		public static final int DRIVE_RIGHT_FRONT = 13;
		public static final int DRIVE_RIGHT_BACK = 15;
		public static final int INTAKE_INNER = 2;// 11
		public static final int INTAKE_OUTER = 10;
		public static final int CLIMBER = 11;// 2
		public static final int GEAR_MANIPULATOR = 5;
	}

	public static class DIOChannels {
	}

	public static class AnalogInChannels {
	}

	public static class RelayChannels {
	}

	public static class SolenoidChannels {
		// inaccurate values, but MUST all be different or else robot won't run
		public static final int DEPLOY_LEFT_RETRACT = 1;
		public static final int DEPLOY_LEFT_EXTEND = 2;
		public static final int SHIFT_HIGH = 4;
		public static final int SHIFT_LOW = 3;
	}

	public static class IntakeConstants {
		// need to tune these
		public static final double DEADZONE = .1675;
		public static final double MAX_POWER = 1.0;
		public static final double SOLENOID_ACTIVE_TIME = .25;
		public static final double INTAKE_POWER = 1;
		public static final double OUTTAKE_POWER = -1;
	}

	public static class DriveBaseConstants {
		public static final double P = .0003;
		public static final double I = 0.0;
		public static final double D = 0.0003;
		public static final int BUFFER = 10;
		public static final double DEADZONE = .1675;
		public static final double MAX_POWER = 1.0;
		public static final double SHIFTER_TIME = .25;
		// 720 tick/rotation / 18.85 in/rotation = 38.2 ticks/inch
		public static final double TICKS_PER_INCH = 410.86;
		public static final double TOLERANCE = TICKS_PER_INCH * 0.5;
	}

	public static class ClimberConstants {

		public static final double CLIMBER_POWER = 1.0;
		public static final double CLIMBER_STOPPED = 0;
		public static final double CURRENT_THRESHOLD = 30;// too low, but
															// unknown what the
															// real value is
		public static final double MIN_STALL_TIME = 0.3;
	}

	public static class GearManipulatorConstants {
		public static final double SOLENOID_ACTIVE_TIME = .25;// untested
		public static final double GEAR_SPINNER_POWER_IN = -1.00; 
		public static final double GEAR_SPINNER_POWER_OUT = 1.00;
		public static final double GEAR_SPINNER_STOPPED = 0;
	}
}
