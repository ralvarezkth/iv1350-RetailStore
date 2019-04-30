package retailstore.integration;

/**
 * 
 * Contains item to be sold and its quantity.
 */
public class ListItem {
	private ItemDTO item;
	private int quantity;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param item The item to be sold.
	 * @param quantity The quantity of the item to be sold.
	 */
	public ListItem(ItemDTO item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	/**
	 * Updates the quantity of the item to be sold.
	 * 
	 * @param quantity The quantity of the item added. 
	 */
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

	/**
	 * Gets the itemDTO of this sold item.
	 * 
	 * @return The itemDTO of this item.
	 */
	public ItemDTO getItemDTO() {
		return this.item;
	}
	
	/**
	 * Gets the quantity of this sold item.
	 * 
	 * @return The quantity of this item.
	 */
	public int getQuantity() {
		return this.quantity;
	}
}
