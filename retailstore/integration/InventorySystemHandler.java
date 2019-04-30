package retailstore.integration;

import retailstore.model.Sale;

/**
 * 
 * @author User
 *
 */
public class InventorySystemHandler {
	
	InventorySystemHandler() {
		
	}
	
	/**
	 * 
	 * @param sale
	 */
	public void sendSaleInformation (Sale sale) {
		System.out.println("Sending sale information to inventory system...");
	}

}
