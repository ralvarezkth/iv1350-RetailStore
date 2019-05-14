package retailstore.integration;

/**
 * 
 * Thrown when the system cannot connect to the database.
 *
 */
public class DatabaseConnectionFailureException extends Exception {
	private static final long serialVersionUID = -5959595959L;
	
	/**
	 * Error exception for when the system cannot connect to the database.
	 * 
	 * @param errorMsg The message explaining the error.
	 */
	public DatabaseConnectionFailureException(String errorMsg) {
		super(errorMsg);
	}
}