package retailstore.integration;

/**
 * Represents the item identifier of an item.
 */
public class ItemIdentifierDTO {
	private String itemIdentifier;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param itemIdentifier The item identifier to be constructed or scanned.
	 */
	public ItemIdentifierDTO(String itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}
	
	/**
	 * Gets the itemIdentifierDTO.
	 * 
	 * @return The itemIdentifier.
	 */
	public String getItemIdentifier() {
		return this.itemIdentifier;
	}

}
