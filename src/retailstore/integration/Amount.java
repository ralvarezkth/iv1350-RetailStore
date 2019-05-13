package retailstore.integration;

/**
 * Represents an amount of money or a discount percentage.
 *
 */
public class Amount {
	private double amount;

	/**
	 * Creates a new instance.
	 * 
	 * @param amount The amount of money or percentage units.
	 */
	public Amount (double amount) {
			this.amount = amount;
	}
	
	/**
	 * Gets the amount value of the instance.
	 * 
	 * @return The amount value.
	 */
	public double getAmount() {
		return this.amount;
	}
	
}
