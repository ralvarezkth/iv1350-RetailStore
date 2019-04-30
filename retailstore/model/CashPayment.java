package retailstore.model;

import retailstore.integration.Amount;

/**
 * Represents a customers payment in cash.
 *
 */
public class CashPayment {
	private Amount paidAmount;
	
	/**
	 * Creates a new instance.
	 * 
	 * @param paidAmount The amount paid by the customer.
	 */
	public CashPayment (Amount paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	/**
	 * Gets the paid amount.
	 * 
	 * @return The paid amount.
	 */
	public Amount getPaidAmount() {
		return this.paidAmount;
	}
}
