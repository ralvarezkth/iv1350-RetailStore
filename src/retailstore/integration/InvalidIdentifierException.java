package retailstore.integration;
/**
 * Thrown when scanning an item identifier that does not exist. 
 */
public class InvalidIdentifierException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with a message specifying the invalid identifier.
	 *  
	 * @param errorMsg The message explaining the error.
	 */
	public InvalidIdentifierException (String errorMsg) {
		
		super(errorMsg);
		
	}
}
