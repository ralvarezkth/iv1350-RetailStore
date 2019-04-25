package retailstore.model;

import retailstore.integration.Amount;

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

}
