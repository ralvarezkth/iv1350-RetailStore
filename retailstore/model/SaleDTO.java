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
	
	public ItemDTO getFoundItem() {
		return this.foundItem;
	}
	
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
	/*
	public String toString() {
		String saleDTO = new String ("");
		
		saleDTO = (
				"Running Total: " +
				"Item name: " + this.foundItem.getName()+
				"Item price: " +
				"Item VATrate: ");
		
		return saleDTO;
	}*/
}
