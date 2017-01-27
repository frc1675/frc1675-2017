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
	public static class CANDeviceIDs{
		//inaccurate info
		public static final int LEFT_FRONT_MOTOR = 3;
		public static final int LEFT_BACK_MOTOR = 0;
		public static final int RIGHT_FRONT_MOTOR = 2;
		public static final int RIGHT_BACK_MOTOR = 0;
		public static final int INTAKE_INNER = 5; 
		public static final int INTAKE_OUTER = 6;
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
	
	
	public static class IntakeConstants{
		public static final double INTAKE_DEADZONE = .1675;
	}
	
	public static class DriveBaseConstants{
		public static final double MOTOR_DEADZONE = .1675;
	}
	
	public static class SolenoidChannels {
		public static final int SOLENOID_ONE = 0;//not the actual values
		public static final int SOLENOID_TWO = 1;
	}
}
