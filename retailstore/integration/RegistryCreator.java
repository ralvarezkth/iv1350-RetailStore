package retailstore.integration;

/**
 * 
 * @author User
 *
 */
public class RegistryCreator {
	public AccountingSystemHandler accountingSystemHandler;
	public InventorySystemHandler inventorySystemHandler;
	public ItemRegistry itemRegistry;
	public SaleLog saleLog;
	public DiscountRules discountRules;
	
	/**
	 * Creates an instance
	 * 
	 */
	public RegistryCreator() {
		this.accountingSystemHandler = new AccountingSystemHandler();
		
		this.inventorySystemHandler = new InventorySystemHandler();
		
		this.itemRegistry = new ItemRegistry();
		
		this.saleLog = new SaleLog();
		
		this.discountRules = new DiscountRules();	
	}
	
}
