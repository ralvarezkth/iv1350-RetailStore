package retailstore.integration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * This class is responsible for the log.
 *
 */
public class LogHandler {
	
	/**
	 * 
	 * @throws IOException
	 */
	public LogHandler() throws IOException {
	}
	
	/**
	 * Writes a log entry describing a thrown exception.
	 * 
	 * @param exc The exception that shall be logged.
	 */
	public void logException(Exception exc) {
		StringBuilder logMsgBuilder = new StringBuilder();
		logMsgBuilder.append(createTime());
		logMsgBuilder.append(", An exception was thrown: ");
		logMsgBuilder.append(exc.getMessage());
		System.out.println(logMsgBuilder);
		// exc.printStackTrace(s);
	}
	
	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}
}
