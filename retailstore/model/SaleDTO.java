package retailstore.model;

import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;

/**
 * Contains the currently scanned item and the runningTotal of the sale.
 */
public class SaleDTO {
	private ItemDTO foundItem;
	private Amount runningTotal;

	/**
	 * Creates a new instance.
	 * 
	 * @param foundItem The found item that corresponds to the scanned item identifier.
	 * @param runningTotal The running total of the sale.
	 */
	SaleDTO (ItemDTO foundItem, Amount runningTotal) {
		this.foundItem = foundItem;
		this.runningTotal = runningTotal;
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
	 * Gets the running total of the current sale.
	 * 
	 * @return runningTotal The running total of the current sale.
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
}
