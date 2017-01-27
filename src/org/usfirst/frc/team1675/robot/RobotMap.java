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
		// inaccurate info
		public static final int LEFT_FRONT_MOTOR = 3;
		public static final int LEFT_BACK_MOTOR = 0;
		public static final int RIGHT_FRONT_MOTOR = 2;
		public static final int RIGHT_BACK_MOTOR = 0;
		public static final int SHOOTER_MOTOR = 0;
	}
	public static class PDChannels {
	}
	public static class DIOChannels {
	}
	public static class AnalogInChannels {
	}
	public static class RelayChannels {
	}
	public static class DriverConstants {
	}
	public static class MotorConstants {
		public static final double DRIVE_DEADZONE = .1675;
		public static final double SHOOTER_DEADZONE = .1675;
		public static final int ENCODER_TICKS_PER_ROTATION = 697;
	}
}