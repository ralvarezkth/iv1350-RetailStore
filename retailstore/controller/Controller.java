package retailstore.controller;

import retailstore.model.Sale;
import retailstore.model.CashRegister;
import retailstore.model.SaleDTO;
import retailstore.model.CashPayment;
import retailstore.integration.RegistryCreator;
import retailstore.integration.ItemDTO;
import retailstore.integration.DiscountRules;
import retailstore.integration.Amount;
import retailstore.integration.CustomerIDDTO;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.Printer;
/**
 *
 * @author User
 *
 */
public class Controller {
	private RegistryCreator creator;
	private Sale sale;
	private Printer printer;
	private CashRegister cashRegister;
	/**
	 * Creates a new instance.
	 *
	 * @param creator Used to get all classes that handle database calls
	 */
	public Controller (RegistryCreator creator, Printer printer) {
		this.creator = creator;
		this.printer = printer;
		this.cashRegister = new CashRegister(creator);
		
	}

	/**
	 * Creates a new instance
	 */
	public void startNewSale() {
		this.sale = new Sale(cashRegister);
	}
	
	/**
	 *
	 * @param itemIdentifier
	 * @param quantity
	 * @return
	 */
	public SaleDTO enterIdentifier(ItemIdentifierDTO itemIdentifier, int quantity) {
		ItemDTO foundItem = creator.itemRegistry.findItem(itemIdentifier);

		if (foundItem == null)
			return null;

		SaleDTO saleDTO = sale.addItem(foundItem, quantity);

		return saleDTO;
	}

	/**
	 *
	 * @param paidAmount
	 * @return
	 */
	public Amount enterPaidAmount (Amount paidAmount) {
		CashPayment payment = new CashPayment(paidAmount);
		Amount change = sale.pay(payment);
		sale.printReceipt(printer);
		creator.getAccountingSystemHandler().sendSaleInformation(sale);
		creator.getInventorySystemHandler().sendSaleInformation(sale);
		return change;
	}

	/**
	 *
	 * @return
	 */
	public Amount signalFinished() {
		sale.updateTotalPrice();
		Amount totalPrice = sale.getTotalPrice();
		return totalPrice;
	}

	/**
	 *
	 * @param customerID
	 * @param sale
	 * @return
	 */
	public Amount discountRequest(CustomerIDDTO customerID) {
		DiscountRules discountRules = creator.discountRules.checkRules(customerID);
		Amount priceAfterDiscount = sale.calculatePriceAfterDiscount(discountRules);

		return priceAfterDiscount;
	}

}
