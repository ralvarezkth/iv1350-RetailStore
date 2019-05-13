package retailstore.model;

import retailstore.integration.Amount;

/**
 * Represents the receipt of a sale.
 */
public class Receipt {
	private String dateOfSale;
	private String timeOfSale;
	private String saleID;
	private Amount totalPrice;
	private Amount totalVAT;
	private Amount change;
	private Amount paidAmount;

	/**
	 * Creates a new instance.
	 * 
	 * @param sale The sale proved by this receipt.
	 */
	Receipt (Sale sale){
		this.dateOfSale = sale.getDateOfSale();
		this.timeOfSale = sale.getTimeOfSale();
		this.saleID 	= sale.getSaleID();
		this.totalPrice = sale.getTotalPrice();
		this.totalVAT 	= sale.getTotalVAT();
		this.change 	= sale.getChange();
		this.paidAmount = sale.getPaidAmount();
	}
}
