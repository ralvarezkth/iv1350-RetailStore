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
	 * Get the itemIdentifier of the Item.
	 * 
	 * @return itemIdentifier The itemIdentifier of the item.
	 */
	public ItemIdentifierDTO getItemIdentifierDTO () {
		return this.itemIdentifier;
	}
	
	/**
	 * Get the price of the item including VAT.
	 * 
	 * @return price The price of the item.
	 */
	public Amount getPrice () {
		return this.price;
	}
	
	/**
	 * Get the VATrate of the item.
	 * 
	 * @return VATrate
	 */
	public Amount getVATrate () {
		return this.VATrate;
	}
	
	/**
	 * Get the name of the item.
	 * 
	 * @return name
	 */
	public String getName () {
		return this.name;
	}
	
	
	
	
	
}
