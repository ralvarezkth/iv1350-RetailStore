package retailstore.model;

import retailstore.integration.ItemDTO;
import retailstore.integration.RegistryCreator;
import retailstore.integration.SaleLog;
import retailstore.integration.Amount;

public class CashRegister {
	private SaleLog saleLog;

	/**
	 * Creates an instance
	 */
	public CashRegister (RegistryCreator creator) {
		this.saleLog = creator.saleLog;
	}
	
	/**
	 * 
	 * @param foundItem
	 * @param quantity
	 */
	void calculateRunningTotal (Sale sale, ItemDTO foundItem, int quantity) {
		
		sale.runningTotal = new Amount (sale.runningTotal.getAmount() 
				+ (foundItem.getPrice().getAmount() * quantity));
	}
	
	void addPayment (Sale sale) {
		saleLog.logSale(sale);
	}
}
