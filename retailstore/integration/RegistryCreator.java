package retailstore.integration;

/**
 * This class is responsible for instantiating all handlers and registers.
 */
public class RegistryCreator {	
	private AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
	private InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
	private ItemRegistry itemRegistry = new ItemRegistry();
	private SaleLog saleLog = new SaleLog();
	private DiscountRules discountRules = new DiscountRules();

	/**
	 * Gets the accountingSystemHandler.
	 * 
	 * @return The accountingSystemHandler.
	 */
	public AccountingSystemHandler getAccountingSystemHandler() {
		return this.accountingSystemHandler;
	}
	
	/**
	 * Gets the inventorySystemHandler.
	 * 
	 * @return The inventorySystemHandler
	 */
	public InventorySystemHandler getInventorySystemHandler() {
		return this.inventorySystemHandler;
	}

	/**
	 * Gets the itemRegistry.
	 * 
	 * @return The itemRegistry
	 */
	public ItemRegistry getItemRegistry() {
		return this.itemRegistry;
	}

	/**
	 * Gets the saleLog.
	 * 
	 * @return The saleLog
	 */
	public SaleLog getSaleLog() {
		return this.saleLog;
	}

	/**
	 * Gets the discountRules.
	 * 
	 * @return The discountRules
	 */
	public DiscountRules getDiscountRules() {
		return this.discountRules;
	}

}
