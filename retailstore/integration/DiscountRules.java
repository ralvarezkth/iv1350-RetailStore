package retailstore.integration;

public class DiscountRules {
	private Amount discountPercentage = new Amount(0);
	
	/**
	 * Creates an instance
	 */
	DiscountRules() {
		
	}
	
	/**
	 * 
	 * @param customerID
	 * @param sale
	 * @return
	 */
	public DiscountRules checkRules(CustomerIDDTO customerID) {
		if (customerID.ID >= 555555) {
			this.discountPercentage = new Amount(0.1);
		}
		return this;
	}
	
	public Amount getDiscountPercentage() {
		return this.discountPercentage;
	}

}
