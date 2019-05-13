package retailstore.integration;
import java.lang.Exception;
/**
 * Thrown when scanning an item identifier that does not exist. 
 */
public class InvalidIdentifierException extends Exception {
	
	private ItemDTO itemWithInvalidIdentifier;
	
	/**
	 * Creates a new instance with a message specifying the invalid identifier.
	 *  
	 * @param itemWithInvalidIdentifier The item whose item identifier does not exist.
	 */
	public InvalidIdentifierException (ItemDTO itemWithInvalidIdentifier) {
		
		super("The item identifier " + itemWithInvalidIdentifier.getItemIdentifierDTO() +
				"does not exist.");
		
		this.itemWithInvalidIdentifier = itemWithInvalidIdentifier;
	}
}
