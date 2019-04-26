package retailstore.integration;

/**
 * 
 * @author User
 *
 */
public class RegistryCreator {
	private AccountingSystemHandler accountingSystemHandler;
	private InventorySystemHandler inventorySystemHandler;
	private ItemRegistry itemRegistry;
	private SaleLog saleLog;
	private DiscountRules discountRules;
	
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
