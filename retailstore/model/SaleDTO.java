package retailstore.model;

import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;

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
}
