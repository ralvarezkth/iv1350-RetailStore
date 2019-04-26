package retailstore.model;

import retailstore.integration.ItemDTO;
import retailstore.integration.RegistryCreator;

public class CashRegister {

	/**
	 * Creates an instance
	 */
	public CashRegister () {
		
	}
	
	/**
	 * 
	 * @param foundItem
	 * @param quantity
	 */
	void calculateRunningTotal (ItemDTO foundItem, int quantity) {
		
	}
	
	void addPayment (Sale sale) {
		logSale(sale);
	}
}
