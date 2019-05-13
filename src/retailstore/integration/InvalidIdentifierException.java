package retailstore.integration;
import java.lang.Exception;
/**
 * Thrown when scanning an item identifier that does not exist. 
 */
public class InvalidIdentifierException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with a message specifying the invalid identifier.
	 *  
	 * @param itemWithInvalidIdentifier The item whose item identifier does not exist.
	 */
	public InvalidIdentifierException (String errorMsg) {
		
		super(errorMsg);
		
	}
}
