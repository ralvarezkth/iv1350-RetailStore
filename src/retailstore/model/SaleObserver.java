package retailstore.model;

/**
 * A listener interface for receiving notifications about
 * completed sales. The class that is interested in such
 * notifications implements this interface, and the object
 * created with that class is registered with Controller.
 * When a sale is completed, that object’s {@link #newSale newSale}
 * method is invoked.
 *
 */
public interface SaleObserver {
	
	/**
	 * Invoked when a sale has been completed and paid for.
	 * 
	 * @param payment The amount paid for the sale.
	 */
	void newSale(CashPayment payment);

}
