package retailstore.integration;

/**
 * 
 * @author User
 *
 */
public class RegistryCreator {
	
	/**
	 * Creates an instance
	 * 
	 */
	public RegistryCreator() {
		AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
		
		InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
		
		ItemRegistry itemRegistry = new ItemRegistry();
		
		SaleLog saleLog = new SaleLog();
		
		DiscountRules discountRules = new DiscountRules();	
	}
	
}
