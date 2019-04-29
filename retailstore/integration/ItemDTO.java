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
	private	ItemIdentifierDTO itemIdentifier;
	
	/**
	 * Creates a new instance representing a particular item.
	 * 
	 * @param price
	 * @param VATrate
	 * @param name
	 */
	public ItemDTO(Amount price, Amount VATrate, String name, ItemIdentifierDTO itemIdentifier) {
		this.price = price;
		this.VATrate = VATrate;
		this.name = name;
		this.itemIdentifier = itemIdentifier;
		
	}
	
	public ItemIdentifierDTO getItemIdentifierDTO () {
		return this.itemIdentifier;
	}
	
	public Amount getPrice () {
		return this.price;
	}
	
	public Amount getVATrate () {
		return this.VATrate;
	}
	
	public String getName () {
		return this.name;
	}
	
	
	
	
	
}
