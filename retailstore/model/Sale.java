package retailstore.model;

import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;
import retailstore.model.CashRegister;

public class Sale {
	private String dateOfSale;
	private String timeOfSale;
	private String saleID;
	private Amount totalPrice;
	private Amount totalVAT;
			Amount runningTotal;
	private Amount change;
	private Amount paidAmount;
	//private <listOfItems> listOfItems; // fix this
	
	/**
	 * Creates a new instance
	 */
	public Sale () {
		
	}
	
	/**
	 * 
	 * @param foundItem
	 * @param quantity
	 * @return
	 */
	public SaleDTO addItem (ItemDTO foundItem, int quantity) {
		calculateRunningTotal (foundItem, quantity);
		SaleDTO saleDTO = new SaleDTO(foundItem, runningTotal);
		
		return saleDTO;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getTotalPrice() {
		Amount totalPrice = this.totalPrice;
		
		return totalPrice;
	}
	
	/**
	 * 
	 * @param payment
	 * @return
	 */
	public Amount pay(CashPayment payment) {
		// calculate change
		addPayment(sale);
		return change;
	}
	
	/**
	 * 
	 * @param discountRules
	 * @return
	 */
	public Amount calculatePriceAfterDiscount(DiscountRules discountRules) {
		return priceAfterDiscount;
	}

}