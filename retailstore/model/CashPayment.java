package retailstore.model;

import retailstore.integration.Amount;

public class CashPayment {
	private Amount paidAmount;
	
	/**
	 * Creates a new instance.
	 * @param paidAmount
	 */
	public CashPayment (Amount paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Amount getPaidAmount() {
		return this.paidAmount;
	}
	

}
