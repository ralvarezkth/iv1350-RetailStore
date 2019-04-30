package retailstore.model;

import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;

/**
 * Contains the currently scanned item and the runningTotal of sale.
 */
public class SaleDTO {
	private ItemDTO foundItem;
	private Amount runningTotal;

	/**
	 * Creates an instance
	 * @param foundItem
	 * @param runningTotal 
	 */
	SaleDTO (ItemDTO foundItem, Amount runningTotal) {
		this.foundItem = foundItem;
		this.runningTotal = runningTotal;
	}
	
	/**
	 * Get the foundItem.
	 * 
	 * @return founfItem The item found.
	 */
	public ItemDTO getFoundItem() {
		return this.foundItem;
	}
	
	/**
	 * Get the running total of the current sale.
	 * 
	 * @return runningTotal The running total of the current sale.
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
	/*
	public String toString() {
	}
	*/
}
