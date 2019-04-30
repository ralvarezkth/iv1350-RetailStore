package retailstore.model;
import java.util.ArrayList;
import java.util.List;
import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;
import retailstore.model.CashRegister;
import retailstore.integration.DiscountRules;
import retailstore.integration.Printer;
import retailstore.model.Receipt;

/**
 * Represents a particular sale, where a particular 
 * customer purchases particular items.
 */
public class Sale {
	private String dateOfSale = "2 maj 2019";
	private String timeOfSale = "12:00";
	private String saleID = "123";
	private Amount totalPrice = new Amount(0);
	private Amount totalVAT;
			Amount runningTotal = new Amount(0);
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
	 *
	 * @param foundItem The found item that corresponds to the scanned item identifier.
	 * @param quantity The quantity of of the scanned item.
	 * @return saleDTO 	containing the itemDTO for the scanned item 
	 * 					and the running total of the sale.
	 */
	public SaleDTO addItem (ItemDTO foundItem, int quantity) {
		listOfItems.add(foundItem);
		cashRegister.calculateRunningTotal (this, foundItem, quantity);
		SaleDTO saleDTO = new SaleDTO(foundItem, runningTotal);

		return saleDTO;
	}

	/**
	 *
	 * @param payment The amount paid by the customer.
	 * @return change 	The change based on the totalPrice of the 
	 * 					sale and the amountPaid by the customer.
	 */
	public Amount pay(CashPayment payment) {
		this.change = new Amount(payment.getPaidAmount().getAmount() - this.totalPrice.getAmount());
		return change;
	}
	
	/**
	 * 
	 * @param printer
	 */
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(this);
		printer.printReceipt (receipt);
		cashRegister.addPayment(this);
	}

	/**
	 * Calculates the price of the sale for a customer
	 * after checking the discount rules.
	 *
	 * @param discountRules 
	 * @return totalPrice 	The totalPrice after checking if the
	 * 						customer is eligible for discount.
	 */
	public Amount calculatePriceAfterDiscount(DiscountRules discountRules) {
		double priceAfterDiscount = this.totalPrice.getAmount() 
				* (1 - discountRules.getDiscountPercentage().getAmount());
		
		this.totalPrice = new Amount(priceAfterDiscount);
		
		return this.totalPrice;
	}
	
	/**
	 * Updates the totalPrice of the sale to the runningTotal
	 * when the sale is signaled as finished.
	 */
	public void updateTotalPrice() {
		this.totalPrice = this.runningTotal;
	}
	
	/**
	 * Get the dateOfSale.
	 * 
	 * @return dateOfSale The date of when the sale was completed.
	 */
	public String getDateOfSale () {
		return this.dateOfSale;
	}
	
	/**
	 * Get the timeOfSale.
	 * 
	 * @return timeOfSale The time of when the sale was completed.
	 */
	public String getTimeOfSale () {
		return this.timeOfSale;
	}
	
	/**
	 * Get the saleID of the sale.
	 * 
	 * @return saleID The saleID of the sale.
	 */
	public String getSaleID () {
		return this.saleID;
	}
	
	/**
	 * Get the totalPrice of the sale.
	 * 
	 * @return totalPrice The totalPrice of the sale.
	 */
	public Amount getTotalPrice () {
		return this.totalPrice;
	}
	
	/**
	 * Get the totalVAT of the sale.
	 * 
	 * @return totalVAT The total VAT of the sale.
	 */
	public Amount getTotalVAT () {
		return this.totalVAT;
	}
	
	/**
	 * Get the change after payment.
	 * 
	 * @return change 	The change based on the totalPrice of the 
	 * 					sale and the amountPaid by the customer.
	 */
	public Amount getChange () {
		return this.change;
	}
	
	/**
	 * Get the paidAmount that the customer handed over.
	 * 
	 * @return paidAmount The amount the customer handed over.
	 */
	public Amount getPaidAmount () {
		return this.paidAmount;
	}
}
