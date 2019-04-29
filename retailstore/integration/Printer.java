package retailstore.integration;

import retailstore.model.Receipt;

/**
 * 
 * @author User
 *
 */
public class Printer {
	
	/**
	 * Creates an instance 
	 */
	public Printer() {
		
	}
	
	public void printReceipt(Receipt receipt) {
		System.out.println("Printing receipt...");
	}

}
