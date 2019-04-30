package retailstore.integration;

import retailstore.model.Sale;

/**
 * 
 * @author User
 *
 */
public class AccountingSystemHandler {
	
	/**
	 * Creates an instance
	 */
	AccountingSystemHandler() {
		
	}
	
	/**
	 * 
	 * @param sale
	 */
	public void sendSaleInformation (Sale sale) {
		System.out.println("Sending sale information to accounting system...");
	}

}
