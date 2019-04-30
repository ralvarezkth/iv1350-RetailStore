package retailstore.integration;

/**
 * This class is responsible for instantiating all handles and registers.
 */
public class RegistryCreator {	
	private AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
	private InventorySystemHandler inventorySystemHandler = new InventorySystemHandler();
	private ItemRegistry itemRegistry = new ItemRegistry();
	private SaleLog saleLog = new SaleLog();
	private DiscountRules discountRules = new DiscountRules();

	/**
	 * Get the accountingSystemHandler.
	 * 
	 * @return accountingSystemHandler
	 */
	public AccountingSystemHandler getAccountingSystemHandler() {
		return this.accountingSystemHandler;
	}
	
	/**
	 * Get the inventorySystemHandler.
	 * 
	 * @return inventorySystemHandler
	 */
	public InventorySystemHandler getInventorySystemHandler() {
		return this.inventorySystemHandler;
	}

	/**
	 * Get the itemRegistry.
	 * 
	 * @return itemRegistry
	 */
	public ItemRegistry getItemRegistry() {
		return this.itemRegistry;
	}

	/**
	 * Get the saleLog.
	 * 
	 * @return saleLog
	 */
	public SaleLog getSaleLog() {
		return this.saleLog;
	}

	/**
	 * Get the discountRules.
	 * 
	 * @return discountRules
	 */
	public DiscountRules getDiscountRules() {
		return this.discountRules;
	}

}
