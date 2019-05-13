package retailstore.integration;

/**
 * Contains customer information, including name and ID.
 *
 */
public class CustomerIDDTO {
	String name;
	int ID;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param name The name of the customer.
	 * @param ID The ID of the customer.
	 */
	public CustomerIDDTO(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}
	
}
