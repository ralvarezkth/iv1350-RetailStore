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
 * This is the only controller class of the application.
 * All calls to the model pass through this class.
 */
public class Controller {
	private RegistryCreator creator;
	private Sale sale;
	private Printer printer;
	private CashRegister cashRegister;
	
	/**
	 * Creates a new instance.
	 *
	 * @param creator Used to get all classes that handle database calls.
	 */
	public Controller (RegistryCreator creator, Printer printer) {
		this.creator = creator;
		this.printer = printer;
		this.cashRegister = new CashRegister(creator);
	}

	/**
	 * 
	 */
	public void startNewSale() {
		this.sale = new Sale(cashRegister);
	}
	
	/**
	 * 
	 *
	 * @param itemIdentifier The itemIdentifier of the scanned item. 
	 * @param quantity The quantity of of the scanned item.
	 * @return saleDTO 	containing the itemDTO for the scanned item 
	 * 					and the running total of the sale.
	 */
	public SaleDTO enterIdentifier(ItemIdentifierDTO itemIdentifier, int quantity) {
		ItemDTO foundItem = creator.getItemRegistry().findItem(itemIdentifier);

		if (foundItem == null)
			return null;

		SaleDTO saleDTO = sale.addItem(foundItem, quantity);

		return saleDTO;
	}

	/**
	 * 
	 *
	 * @param paidAmount
	 * @return change The change after payment.
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
	 * 
	 * @return totalPrice The total price of the sale.
	 */
	public Amount signalFinished() {
		sale.updateTotalPrice();
		Amount totalPrice = sale.getTotalPrice();
		return totalPrice;
	}

	/**
	 * 
	 *
	 * @param customerID The customerID belonging to the customer going through <code>sale</code>.
	 * @param sale The current sale.
	 * @return priceAfterDiscount 	The price after checking the <code>discountRules</code> for the
	 * 								specified <code>customerID</code> and <code>sale</code>.
	 */
	public Amount discountRequest(CustomerIDDTO customerID) {
		DiscountRules discountRules = creator.getDiscountRules().checkRules(customerID);
		Amount priceAfterDiscount = sale.calculatePriceAfterDiscount(discountRules);

		return priceAfterDiscount;
	}

}
