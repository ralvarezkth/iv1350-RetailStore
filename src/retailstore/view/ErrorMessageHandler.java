package retailstore.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * This class handles error messages for the user.
 *
 */
public class ErrorMessageHandler {

	void showErrorMessage(String message) {
		
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("ERROR: ");
		errorMessage.append("(");
		errorMessage.append(createTime());
		errorMessage.append(") \n");
		errorMessage.append(message);
		System.out.println(errorMessage);
		
		
	}
	
	/**
	 * Writes a log entry describing a thrown exception.
	 * 
	 * @param exc The exception that shall be logged.
	 */
	void logException(Exception exc) {
		StringBuilder logMsgBuilder = new StringBuilder();
		logMsgBuilder.append("\nThe following message is intended to be stored in a log file: \n");
		logMsgBuilder.append(createTime());
		logMsgBuilder.append(", An exception was thrown: ");
		logMsgBuilder.append(exc.getMessage());
		System.out.println(logMsgBuilder);
		exc.printStackTrace();
	}
	
	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		
		return now.format(formatter);
	}
	

	
}
