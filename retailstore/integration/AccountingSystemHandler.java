package retailstore.integration;

import retailstore.model.Sale;

/**
 * Contains all calls to the external accounting sSystem.
 */
public class AccountingSystemHandler {
	
	/**
	 * Creates an instance
	 */
	AccountingSystemHandler() {
		
	}
	
	/**
	 * Sends information about the specified sale to
	 * the external accounting system.
	 * 
	 * @param sale The specified sale.
	 */
	public void sendSaleInformation (Sale sale) {
		System.out.println("Sending sale information to accounting system...");
	}

}
