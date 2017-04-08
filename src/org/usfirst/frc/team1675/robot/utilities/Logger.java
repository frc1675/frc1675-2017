package org.usfirst.frc.team1675.robot.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	File file;
	FileOutputStream fos;

	public Logger(String fileName) {
		file = new File("/media/sda1/" + fileName);
		openLog();
		info("***And we're live coming at you from Narnia***");
	}

	public void openLog() {
		try {
			fos = new FileOutputStream(file, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void closeLog() {

		if (fos == null)
			return;

		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void error(String message) {
		log(getFormattedLog(message, "ERROR"));

	}

	public void info(String message) {
		log(getFormattedLog(message, "INFO"));
	}

	private String getFormattedLog(String message, String logType) {
		String formatedMessage = "(" + getDateTimeAsString() + ")" + "\t" + logType + "\t" + message + "\n";
		return formatedMessage;
	}

	private void log(String message) {

		if (fos == null)
			return;

		try {
			fos.write(message.getBytes());
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getDateTimeAsString() {
		Date date = new Date();
		long time = date.getTime();
		SimpleDateFormat stf = new SimpleDateFormat("MM/dd/yyyy" + "\t" + "HH:mm:ss.SSS");
		String formatedDate = stf.format(date);
		return formatedDate;
	}
}
