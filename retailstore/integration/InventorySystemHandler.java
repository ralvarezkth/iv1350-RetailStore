package retailstore.integration;

import retailstore.model.Sale;

/**
 * Contains all calls to the external inventory system.
 */
public class InventorySystemHandler {
	
	InventorySystemHandler() {
		
	}
	
	/**
	 * Sends information about the specified sale to
	 * the external inventory system.
	 * 
	 * @param sale The specified sale.
	 */
	public void sendSaleInformation (Sale sale) {
		System.out.println("Sending sale information to inventory system...");
	}

}
