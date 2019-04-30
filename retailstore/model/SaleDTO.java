package retailstore.model;

import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;

/**
 * 
 */
public class SaleDTO {
	private ItemDTO foundItem;
	private Amount runningTotal;

	/**
	 * Creates an instance
	 * @param foundItem
	 * @param runningTotal
	 * @return
	 */
	SaleDTO (ItemDTO foundItem, Amount runningTotal) {
		this.foundItem = foundItem;
		this.runningTotal = runningTotal;
		
	}
	
	/**
	 * Get the foundItem.
	 * 
	 * @return the item found.
	 */
	public ItemDTO getFoundItem() {
		return this.foundItem;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
	/*
	public String toString() {
	}
	*/
}
