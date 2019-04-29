package retailstore.integration;

import retailstore.model.Sale;

public class SaleLog {
	
	/**
	 * Creates an instance
	 */
	SaleLog() {
		
	}
	
	/**
	 * 
	 * @param sale
	 */
	public void logSale(Sale sale) {
		System.out.println("Logging sale...");
		
	}

}
