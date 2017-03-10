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
		public static final int INTAKE_INNER = 5;
		public static final int INTAKE_OUTER = 6;
		public static final int AUGER = 12;
		public static final int ELEVATOR_LEFT = 8;
		public static final int ELEVATOR_RIGHT = 9;
		public static final int SHOOTER_LEFT = 10;
		public static final int SHOOTER_RIGHT = 11;
		//climber will be 7
	}

	public static class PDChannels {
		public static final int DRIVE_LEFT_FRONT = 1;
		public static final int DRIVE_LEFT_BACK = 0;
		public static final int DRIVE_RIGHT_FRONT = 14;
		public static final int DRIVE_RIGHT_BACK = 15;
		public static final int INTAKE_INNER = 11;
		public static final int INTAKE_OUTER = 10;
		public static final int AUGER = 12;
		public static final int ELEVATOR_LEFT= 4;
		public static final int ELEVATOR_RIGHT = 5;
		public static final int SHOOTER_LEFT = 3;
		public static final int SHOOTER_RIGHT = 13;
		//climber will be 2
	}

	public static class DIOChannels {
		public static final int SHOOTER_COUNTER = 0;
	}

	public static class AnalogInChannels {
	}

	public static class RelayChannels {
	}

	public static class SolenoidChannels {
		// inaccurate values, but MUST all be different or else robot won't run
		public static final int DEPLOY_LEFT_RETRACT = 2;
//		public static final int DEPLOY_RIGHT_RETRACT = 5;
		public static final int DEPLOY_LEFT_EXTEND = 1;
//		public static final int DEPLOY_RIGHT_EXTEND = 6;
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
		public static final double DEADZONE = .1675;
		public static final double MAX_POWER = 1.0;
		public static final int ENCODER_TICKS_PER_REVOLUTION = 697;//"alternative facts"
		public static final double SHIFTER_TIME = .25;
	}

	public static class ShooterConstants {
		public static final double DEADZONE = .1675;
		public static final double MAX_POWER = 1.0;
		public static final int COUNTER_PULSES_PER_REVOLUTION = 4;

		public static final double BANGBANG_LOW = 0.0;
		public static final double BANGBANG_HIGH = 1.0;
		
		public static final double SETPOINT_RPM = 2650;
		
		public static final double P = .0001; //workable value is .001
		public static final double I = .0005; //workable value is .0005
		public static final double D = .0;
		
		public static final double FORWARDS_POWER = 1.0;
		public static final double BACKWARDS_POWER = -1.0;
	}

	public static class ElevatorConstants {
		public static final double DEADZONE = .1675;
		public static final double MAX_POWER = 1.0;
		public static final double FORWARDS_POWER = 1.0;
		public static final double BACKWARDS_POWER = -1.0;
	}

	public static class AugerConstants {
		public static final double DEADZONE = .1;
		public static final double MAX_POWER = .15;

		public static final double BACKWARDS_POWER = -1.0;
		public static final double FORWARDS_POWER = 1.0;
		
		public static final double FORWARDS_CURRENT_THRESHOLD = 5;//not accurate
		public static final double BACKWARDS_CURRENT_THRESHOLD = 5;//not accurate
		
		public static final double MIN_JAM_SECONDS = .4;//inaccurate
		public static final double MIN_DOUBLE_JAM_SECONDS = .4;//inaccurate
		public static final double UNJAM_DURATION = 1.0;//inaccurate
		public static final double SETTLE_DURATION = 1.0;//inaccurate
	}
}
