package retailstore.integration;

/**
 * Contains information about one particular item.
 */
public class ItemDTO {
	private Amount price;
	private Amount VATrate;
	private String name;
	private	ItemIdentifierDTO itemIdentifier;
	
	/**
	 * Creates a new instance representing a particular item.
	 * 
	 * @param price The price of the item including VAT.
	 * @param VATrate The VAT rate of the item.
	 * @param name The name of the item.
	 * @param itemIdentifier The itemIdentifier of the item.
	 */
	public ItemDTO(Amount price, Amount VATrate, String name, ItemIdentifierDTO itemIdentifier) {
		this.price = price;
		this.VATrate = VATrate;
		this.name = name;
		this.itemIdentifier = itemIdentifier;
		
	}
	
	/**
	 * Get the ite
	 * @return
	 */
	public ItemIdentifierDTO getItemIdentifierDTO () {
		return this.itemIdentifier;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getPrice () {
		return this.price;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getVATrate () {
		return this.VATrate;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName () {
		return this.name;
	}
	
	
	
	
	
}
