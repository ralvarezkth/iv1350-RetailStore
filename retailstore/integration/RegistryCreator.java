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
	 * 
	 * @return
	 */
	public AccountingSystemHandler getAccountingSystemHandler() {
		return this.accountingSystemHandler;
	}
	
	/**
	 * 
	 * @return
	 */
	public InventorySystemHandler getInventorySystemHandler() {
		return this.inventorySystemHandler;
	}

	/**
	 * 
	 * @return
	 */
	public ItemRegistry getItemRegistry() {
		return this.itemRegistry;
	}

	/**
	 * 
	 * @return
	 */
	public SaleLog getSaleLog() {
		return this.saleLog;
	}

	/**
	 * 
	 * @return
	 */
	public DiscountRules discountRules() {
		return this.discountRules;
	}

}
