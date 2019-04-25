package retailstore.controller;

import retailstore.model.Sale;
import retailstore.integration.ItemRegistry;
import retailstore.integration.RegistryCreator;

public class Controller {
	
	
	/**
	 * Creates a new instance.
	 * 
	 * @param creator Used to get all classes that handle database calls	
	 */
	public Controller (RegistryCreator creator) {
		
		// code
	}
	
	/**
	 * Creates a new instance
	 */
	public void startNewSale() {
		
		Sale sale = new Sale();
	}
	
	/**
	 * 
	 * @param itemIdentifier
	 * @param quantity
	 * @return
	 */
	public SaleDTO enterIdentifier(String itemIdentifier, int quantity) {
		
		ItemDTO foundItem = findItem(itemIdentifier);
		
		enterNewIdentifier();
		
		SaleDTO saleDTO = addItem(foundItem, quantity);
		
		return saleDTO;
	}
	
}
