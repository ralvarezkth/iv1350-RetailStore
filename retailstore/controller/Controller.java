package retailstore.controller;

import retailstore.model.Sale;
import retailstore.model.CashRegister;
import retailstore.model.SaleDTO;
import retailstore.model.CashPayment;
import retailstore.integration.ItemRegistry;
import retailstore.integration.RegistryCreator;
import retailstore.integration.ItemDTO;
import retailstore.integration.DiscountRules;
import retailstore.integration.Amount;

/**
 * 
 * @author User
 *
 */
public class Controller {
	private RegistryCreator creator;
	private Sale sale;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param creator Used to get all classes that handle database calls	
	 */
	public Controller (RegistryCreator creator) {
		this.creator = creator;
		CashRegister cashRegister = new CashRegister();
	}
	
	/**
	 * Creates a new instance
	 */
	public void startNewSale() {
		this.sale = new Sale();
	}
	
	/**
	 * 
	 * @param itemIdentifier
	 * @param quantity
	 * @return
	 */
	public SaleDTO enterIdentifier(String itemIdentifier, int quantity) {
		ItemDTO foundItem = findItem(itemIdentifier);
		
		//enterNewIdentifier();
		
		SaleDTO saleDTO = addItem(foundItem, quantity);
		
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
		printReceipt(printer);
		return change; 
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount signalFinished() {
		Amount totalPrice = getTotalPrice();
		
		return totalPrice;
	}
	
	/**
	 * 
	 * @param customerID
	 * @param sale
	 * @return
	 */
	public Amount discountRequest(CustomerIDDTO customerID, Sale sale) {
		DiscountRules discountRules = checkRules(customerID, sale);
		Amount priceAfterDiscount = calculatePriceAfterDiscount(discountRules);
		
		return priceAfterDiscount;
	}
	
}
