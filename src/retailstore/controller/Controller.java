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
 * All calls to the model passes through this class.
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
	 * @param printer Interface to printer.
	 */
	public Controller (RegistryCreator creator, Printer printer) {
		this.creator = creator;
		this.printer = printer;
		this.cashRegister = new CashRegister(creator);
	}

	/**
	 * Starts a new sale
	 */
	public void startNewSale() {
		this.sale = new Sale(cashRegister);
	}

	/**
	 * Retrieves an item matching the identifier in the argument.
	 *
	 * @param itemIdentifier The itemIdentifier of the scanned item. 
	 * @return saleDTO 	Contains the itemDTO for the scanned item, its quantity 
	 * 					and the running total of the sale.
	 */
	public SaleDTO enterIdentifier(ItemIdentifierDTO itemIdentifier) {
		int quantity = 1;
		
		return enterIdentifier(itemIdentifier, quantity);
	
	}

	/**
	 * Retrieves an item matching the identifier in the argument.
	 *
	 * @param itemIdentifier The itemIdentifier of the scanned item. 
	 * @param quantity The quantity of the scanned item.
	 * @return saleDTO 	Contains the itemDTO for the scanned item, its quantity 
	 * 					and the running total of the sale.
	 */
	public SaleDTO enterIdentifier(ItemIdentifierDTO itemIdentifier, int quantity) {

		ItemDTO foundItem = creator.getItemRegistry().findItem(itemIdentifier);

		if (foundItem == null) {
			System.out.println("No item was found.");
		return null;
		}
		SaleDTO saleDTO = sale.addItem(foundItem, quantity);

		return saleDTO;
	}

	/**
	 * Takes the amount paid and sends sale information to external systems.
	 *
	 * @param paidAmount The amount paid by the customer.
	 * @return change The amount of change to give to the customer.
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
	 * Signals that item scanning is complete and updates the total price of the sale. 
	 * 
	 * @return totalPrice The total price of the sale.
	 */
	public Amount signalFinished() {
		sale.updateTotalPrice();
		Amount totalPrice = sale.getTotalPrice();

		return totalPrice;
	}

	/**
	 * Checks customer eligibility for a discount.
	 *
	 * @param customerID The customerID belonging to the customer in the current <code>sale</code>.
	 * @return priceAfterDiscount 	The price after checking the <code>discountRules</code> for the
	 * 								specified <code>customerID</code> and <code>sale</code>.
	 */
	public Amount discountRequest(CustomerIDDTO customerID) {
		DiscountRules discountRules = creator.getDiscountRules().checkRules(customerID);
		Amount priceAfterDiscount = sale.calculatePriceAfterDiscount(discountRules);
		
		return priceAfterDiscount;
	}

}
