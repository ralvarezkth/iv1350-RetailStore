package retailstore.model;

import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;

/**
 * Contains the currently scanned item, its quantity and the runningTotal of the sale.
 */
public class SaleDTO {
	private ItemDTO foundItem;
	private int quantity;
	private Amount runningTotal;

	/**
	 * Creates a new instance.
	 * 
	 * @param foundItem The found item that corresponds to the scanned item identifier.
	 * @param quantity The quantity of the found item.
	 * @param runningTotal The running total of the sale.
	 */
	SaleDTO (ItemDTO foundItem, int quantity, Amount runningTotal) {
		this.foundItem = foundItem;
		this.runningTotal = runningTotal;
		this.quantity = quantity;
	}
	
	/**
	 * Gets the foundItem.
	 * 
	 * @return founfItem The found item.
	 */
	public ItemDTO getFoundItem() {
		return this.foundItem;
	}
	
	/**
	 * Gets the quantity of the found item.
	 * 
	 * @return The quantity of the found item.
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Gets the running total of the current sale.
	 * 
	 * @return runningTotal The running total of the current sale.
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
}
