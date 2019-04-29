package retailstore.integration;

import retailstore.model.Sale;

public class AccountingSystemHandler {
	/**
	 * Creates an instance
	 */
	AccountingSystemHandler() {
		
	}
	
	public void sendSaleInformation (Sale sale) {
		System.out.println("Sending sale information to accounting system...");
	}

}
