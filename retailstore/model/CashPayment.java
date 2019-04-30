package retailstore.model;

import retailstore.integration.Amount;

/**
 * 
 * @author User
 *
 */
public class CashPayment {
	private Amount paidAmount;
	
	/**
	 * Creates a new instance.
	 * @param paidAmount
	 */
	public CashPayment (Amount paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getPaidAmount() {
		return this.paidAmount;
	}
	

}
