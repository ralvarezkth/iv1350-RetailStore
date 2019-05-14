package retailstore.controller;

/**
 * 
 * Thrown when an operation fails.
 *
 */
public class OperationFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with a message specifying the invalid identifier.
	 *  
	 * @param errorMsg The message explaining the error.
	 */
	public OperationFailedException (String errorMsg) {
		
		super(errorMsg);
		
	}
}

