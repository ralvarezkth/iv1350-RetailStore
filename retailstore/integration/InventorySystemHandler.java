package retailstore.integration;

import retailstore.model.Sale;

/**
 * This class is a placeholder for all calls to the external inventory system.
 * 
 */
public class InventorySystemHandler {
	
	InventorySystemHandler() {
		
	}
	
	/**
	 * Sends information about the current sale to
	 * the external inventory system.
	 * 
	 * @param sale The current sale.
	 */
	public void sendSaleInformation (Sale sale) {
		System.out.println("Sending sale information to inventory system...");
	}

}
