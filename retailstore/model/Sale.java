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
 * 
 * @author User
 *
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
	 * @param foundItem
	 * @param quantity
	 * @return
	 */
	public SaleDTO addItem (ItemDTO foundItem, int quantity) {
		listOfItems.add(foundItem);
		cashRegister.calculateRunningTotal (this, foundItem, quantity);
		SaleDTO saleDTO = new SaleDTO(foundItem, runningTotal);

		return saleDTO;
	}

	/**
	 *
	 * @param payment
	 * @return
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
	
	/**
	 * 
	 */
	public void updateTotalPrice() {
		this.totalPrice = this.runningTotal;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDateOfSale () {
		return this.dateOfSale;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTimeOfSale () {
		return this.timeOfSale;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSaleID () {
		return this.saleID;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getTotalPrice () {
		return this.totalPrice;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getTotalVAT () {
		return this.totalVAT;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getChange () {
		return this.change;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getPaidAmount () {
		return this.paidAmount;
	}
}
