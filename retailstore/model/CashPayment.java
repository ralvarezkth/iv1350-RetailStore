package retailstore.model;

import retailstore.integration.Amount;

public class CashPayment {
	private Amount amount;
	
	/**
	 * Creates a new instance.
	 * @param paidAmount
	 */
	public CashPayment (Amount paidAmount) {
		this.amount = paidAmount;
	}
	

}
