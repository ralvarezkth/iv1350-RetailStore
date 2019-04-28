package retailstore.model;
import java.util.ArrayList;
import java.util.List;
import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;
import retailstore.model.CashRegister;
import retailstore.integration.DiscountRules;
import retailstore.integration.Printer;

public class Sale {
	private String dateOfSale;
	private String timeOfSale;
	private String saleID;
	private Amount totalPrice;
	private Amount totalVAT;
			Amount runningTotal;
	private Amount change;
	private Amount paidAmount;
	private CashPayment cashPayment;
	private List<ItemDTO> listOfItems = new ArrayList<>();
	private CashRegister cashRegister;
	

	/**
	 * Creates a new instance
	 */
	public Sale (CashRegister cashRegister) {
		this.cashRegister = cashRegister;

	}

	/**
	 *
	 * @param foundItem
	 * @param quantity
	 * @return
	 */
	public SaleDTO addItem (ItemDTO foundItem, int quantity) {
		cashRegister.calculateRunningTotal (foundItem, quantity);
		SaleDTO saleDTO = new SaleDTO(foundItem, runningTotal);

		return saleDTO;
	}

	/**
	 *
	 * @return
	 */
	public Amount getTotalPrice() {
		this.totalPrice = this.runningTotal;
		return this.totalPrice;
	}

	/**
	 *
	 * @param payment
	 * @return
	 */
	public Amount pay(CashPayment payment) {
		// calculate change
		cashRegister.addPayment(this);
		return change;
	}
	
	public void printReceipt(Printer printer) {
		// print receipt
	}

	/**
	 *
	 * @param discountRules
	 * @return
	 */
	public Amount calculatePriceAfterDiscount(DiscountRules discountRules) {
		double priceAfterDiscount = this.totalPrice.getAmount() 
				* (1 - discountRules.getDiscountPercentage().getAmount());
		
		this.totalPrice = new Amount(priceAfterDiscount);
		
		return this.totalPrice;
	}

}
