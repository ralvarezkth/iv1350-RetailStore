package retailstore.integration;

import retailstore.model.Receipt;

/**
 * This class is a placeholder for all calls to the external printer. 
 */
public class Printer {
	
	/**
	 * Creates an instance. 
	 */
	public Printer() {
		
	}
	
	/**
	 * Calls the external printer to print the specified receipt. 
	 * 
	 * @param receipt The receipt for the current sale.
	 */
	public void printReceipt(Receipt receipt) {
		System.out.println("Printing receipt...");
	}

}
