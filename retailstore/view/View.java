package retailstore.view;

import retailstore.controller.Controller;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.CustomerIDDTO;;

/**
 * This program has no view, instead, this class is a placeholder for the entire view.
 */
public class View {
	private Controller contr;
	
	/**
	 * Creates an instance
	 * 
	 * @param contr	The controller that is used for all operations.
	 */
	public View (Controller contr) {
		this.contr = contr;
	}
	
	/**
	 * Simulates a user input that generates calls to all system operations.
	 */
	public void sampleExecution() {
		//startNewSale();
		
		ItemIdentifierDTO validItemIdentifier = new ItemIdentifierDTO("0123456789");
		ItemIdentifierDTO invalidItemIdentifier = new ItemIdentifierDTO("0000000000");
		
		CustomerIDDTO customerWithDiscount = new CustomerIDDTO("Rolf", "999999"); 
		CustomerIDDTO customerWithoutDiscount = new CustomerIDDTO("Ellinor", "000000");
	}
	
}
