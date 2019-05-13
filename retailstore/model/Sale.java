package retailstore.model;
import java.util.ArrayList;
import java.util.List;
import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;
import retailstore.integration.ListItem;
import retailstore.model.CashRegister;
import retailstore.integration.DiscountRules;
import retailstore.integration.Printer;
import retailstore.model.Receipt;
import retailstore.model.SaleDTO;

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
	private List<ListItem> listOfItems = new ArrayList<>();
	private CashRegister cashRegister;


	/**
	 * Creates a new instance.
	 *
	 * @param cashRegister The cash register that performs calculations for the sale.
	 */
	public Sale (CashRegister cashRegister) {
		this.cashRegister = cashRegister;

	}

	/**
	 * Adds items to the list of items to be sold in the current sale.
	 *
	 * @param foundItem The found item that corresponds to the scanned item identifier.
	 * @param quantity The quantity of the scanned item.
	 * @return saleDTO 	Contains the itemDTO for the scanned item, its quantity
	 * 					and the running total of the sale.
	 */
	public SaleDTO addItem (ItemDTO foundItem, int quantity) {
		ListItem listItem = new ListItem(foundItem, quantity);
		cashRegister.calculateRunningTotal (this, foundItem, quantity);
		
		if (listOfItems.size() == 0) {
			listOfItems.add(listItem);
		}
		
		else {
			for(int i = 0; i < listOfItems.size(); i++) {
				if(foundItem.equals(listOfItems.get(i).getItemDTO())) {

					ListItem itemWithIncreasedQuantity = listOfItems.get(i);
					itemWithIncreasedQuantity.addQuantity(quantity);
					listOfItems.set(i, itemWithIncreasedQuantity);

					return new SaleDTO(foundItem, itemWithIncreasedQuantity.getQuantity(), runningTotal);
				}
			}
			listOfItems.add(listItem);
		}

		return new SaleDTO(foundItem, quantity, runningTotal);

	}

	/**
	 * Takes payment from the customer and calculates the change.
	 *
	 * @param payment The amount paid by the customer.
	 * @return change The amount of change to give to the customer.
	 */
	public Amount pay(CashPayment payment) {
		this.change = new Amount(payment.getPaidAmount().getAmount() - this.totalPrice.getAmount());
		return change;
	}

	/**
	 * Signals the external printer to print a receipt.
	 *
	 * @param printer Interface to printer.
	 */
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(this);
		printer.printReceipt (receipt);
		cashRegister.addPayment(this);
	}

	/**
	 * Calculates a discounted price.
	 *
	 * @param discountRules The rules that define the discount.
	 * @return totalPrice The totalPrice after checking if the
	 * 						customer is eligible for a discount.
	 */
	public Amount calculatePriceAfterDiscount(DiscountRules discountRules) {
		double priceAfterDiscount = this.totalPrice.getAmount()
				* (1 - discountRules.getDiscountPercentage().getAmount());

		this.totalPrice = new Amount(priceAfterDiscount);

		return this.totalPrice;
	}

	/**
	 * Updates the totalPrice to match the runningTotal
	 * when the sale is signaled as finished.
	 */
	public void updateTotalPrice() {
		this.totalPrice = this.runningTotal;
	}

	/**
	 * Gets the dateOfSale.
	 *
	 * @return dateOfSale The date when the sale was completed.
	 */
	public String getDateOfSale () {
		return this.dateOfSale;
	}

	/**
	 * Gets the timeOfSale.
	 *
	 * @return timeOfSale The time when the sale was completed.
	 */
	public String getTimeOfSale () {
		return this.timeOfSale;
	}

	/**
	 * Gets the saleID of the sale.
	 *
	 * @return saleID The saleID of the sale.
	 */
	public String getSaleID () {
		return this.saleID;
	}

	/**
	 * Gets the totalPrice of the sale.
	 *
	 * @return totalPrice The totalPrice of the sale.
	 */
	public Amount getTotalPrice () {
		return this.totalPrice;
	}

	/**
	 * Gets the totalVAT of the sale.
	 *
	 * @return totalVAT The total VAT of the sale.
	 */
	public Amount getTotalVAT () {
		return this.totalVAT;
	}

	/**
	 * Gets the change after payment.
	 *
	 * @return change The amount of change to give to the customer.
	 */
	public Amount getChange () {
		return this.change;
	}

	/**
	 * Gets the paid amount by the customer.
	 *
	 * @return paidAmount The amount paid by the customer.
	 */
	public Amount getPaidAmount () {
		return this.paidAmount;
	}
}
