package retailstore.model;

import retailstore.integration.ItemDTO;
import retailstore.integration.RegistryCreator;
import retailstore.integration.SaleLog;
import retailstore.integration.Amount;

/**
 * This class handles calculations for the current sale and adds payment to the sale log. 
 */
public class CashRegister {
	private SaleLog saleLog;

	/**
	 * Creates a new instance.
	 * 
	 * @param creator Used to get all classes that handle database calls.
	 */
	public CashRegister (RegistryCreator creator) {
		this.saleLog = creator.getSaleLog();
	}
	
	void calculateRunningTotal (Sale sale, ItemDTO foundItem, int quantity) {
		
		sale.runningTotal = new Amount (sale.runningTotal.getAmount() 
				+ (foundItem.getPrice().getAmount() * quantity));
	}
	
	void addPayment (Sale sale) {
		saleLog.logSale(sale);
	}
}
