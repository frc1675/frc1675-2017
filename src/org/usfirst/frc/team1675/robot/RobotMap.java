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
		public static final int LEFT_FRONT_MOTOR = 1;
		public static final int LEFT_BACK_MOTOR = 2;
		public static final int RIGHT_FRONT_MOTOR = 3;
		public static final int RIGHT_BACK_MOTOR = 4;
		public static final int INTAKE_INNER = 0;
		public static final int INTAKE_OUTER = 0;
		public static final int AUGER_MOTOR = 0;
		public static final int LEFT_ELEVATOR_MOTOR = 0;//1 when tested
		public static final int RIGHT_ELEVATOR_MOTOR = 0;//4 when tested
		public static final int LEFT_SHOOTER_MOTOR = 0;//2 when tested
		public static final int RIGHT_SHOOTER_MOTOR = 0;//3 when tested
	}

	public static class PDChannels {
		public static final int LEFT_FRONT_POWER_CHANNEL = 0;
		public static final int LEFT_BACK_POWER_CHANNEL = 0;
		public static final int RIGHT_FRONT_POWER_CHANNEL = 3;
		public static final int RIGHT_BACK_POWER_CHANNEL = 0;
		public static final int INTAKE_INNER_POWER_CHANNEL = 0;
		public static final int INTAKE_OUTER_POWER_CHANNEL = 0;
		public static final int AUGER_MOTOR_POWER_CHANNEL = 0;
		public static final int LEFT_ELEVATOR_POWER_CHANNEL= 0;
		public static final int RIGHT_ELEVATOR_POWER_CHANNEL = 0;
		public static final int LEFT_SHOOTER_POWER_CHANNEL = 0;
		public static final int RIGHT_SHOOTER_POWER_CHANNEL = 0;
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
		public static final int DEPLOY_LEFT_RETRACT = 0;
		public static final int DEPLOY_RIGHT_RETRACT = 1;
		public static final int DEPLOY_LEFT_EXTEND = 2;
		public static final int DEPLOY_RIGHT_EXTEND = 3;
        public static final int SHIFT_HIGH = 4;
		public static final int SHIFT_LOW = 5;
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
		public static final double MAX_POWER = 1;
		public static final int COUNTER_PULSES_PER_REVOLUTION = 4;

		public static final double BANGBANG_LOW = 0.0;
		public static final double BANGBANG_HIGH = 1.0;
		
		public static final double SETPOINT_RPM = 2500;
		
		public static final double P = .001; //workable value is .001
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
		public static final double DEADZONE = .1675;
		public static final double MAX_POWER = 1.0;

		public static final double SPIN_BACKWARDS = -1.0;
		public static final double SPIN_FORWARDS = 1.0;
	}
}
