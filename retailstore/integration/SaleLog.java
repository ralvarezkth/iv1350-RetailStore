package retailstore.integration;

import retailstore.model.Sale;

/**
 * Contains all calls to the sale log where every sale of the store is logged.
 */
public class SaleLog {
	
	SaleLog() {
		
	}
	
	/**
	 * Logs the current, specified, sale in sale log.
	 * 
	 * @param sale The current sale.
	 */
	public void logSale(Sale sale) {
		System.out.println("Logging sale...");
		
	}

}
