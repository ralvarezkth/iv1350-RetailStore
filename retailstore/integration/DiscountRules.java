package retailstore.integration;

/**
 * Contains the rules that define a customer to be eligible 
 * for a discount.
 *
 */
public class DiscountRules {
	private Amount discountPercentage = new Amount(0);
	
	DiscountRules() {
		
	}
	
	/**
	 * Checks if the customer meets the requirements for a discount.
	 * 
	 * @param customerID The ID of the customer.
	 * @return This instance of the class.
	 */
	public DiscountRules checkRules(CustomerIDDTO customerID) {
		if (customerID.ID >= 555555) {
			this.discountPercentage = new Amount(0.1);
		}
		return this;
	}
	
	/**
	 * Gets the discount percentage for the customer.
	 * 
	 * @return The discount percentage.
	 */
	public Amount getDiscountPercentage() {
		return this.discountPercentage;
	}

}
