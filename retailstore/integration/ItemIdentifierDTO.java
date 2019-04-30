package retailstore.integration;

/**
 * Represents the item identifier of an item.
 */
public class ItemIdentifierDTO {
	private String itemIdentifier;
	
	/**
	 * Creates an instance
	 * 
	 * @param itemIdentifier The item identifier to be constructed or scanned.
	 */
	public ItemIdentifierDTO(String itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}
	
	/**
	 * Get the itemIdentifierDTO.
	 * 
	 * @return the itemIdentifier.
	 */
	public String getItemIdentifier() {
		return this.itemIdentifier;
	}

}
