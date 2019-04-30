package retailstore.integration;

import retailstore.model.Receipt;

/**
 * Handles calls to the external system, printer. 
 */
public class Printer {
	
	/**
	 * Creates an instance 
	 */
	public Printer() {
		
	}
	
	/**
	 * Calls the external system, printer, to print the specified receipt. 
	 * 
	 * @param receipt The receipt for the current sale.
	 */
	public void printReceipt(Receipt receipt) {
		System.out.println("Printing receipt...");
	}

}
