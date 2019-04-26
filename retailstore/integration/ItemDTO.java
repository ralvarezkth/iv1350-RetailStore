package retailstore.integration;

/**
 * 
 * @author User
 *
 */
public class ItemDTO {
	private Amount price;
	private Amount VATrate;
	private String name;
	
	/**
	 * Creates a new instance representing a particular item.
	 * 
	 * @param price
	 * @param VATrate
	 * @param name
	 */
	public ItemDTO(Amount price, Amount VATrate, String name) {
		this.price = price;
		this.VATrate = VATrate;
		this.name = name;
		
	}
	
}