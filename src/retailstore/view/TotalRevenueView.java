package retailstore.view;

import retailstore.integration.Amount;
import retailstore.model.CashPayment;
import retailstore.model.SaleObserver;

/**
 * Shows the total revenue on the display since the program was started.
 * 
 */
public class TotalRevenueView implements SaleObserver {

	private Amount totalRevenue = new Amount(0);
	public TotalRevenueView(){
	}
	
	@Override
	public void newSale (CashPayment payment) {
		addNewPayment(payment);
		printCurrentState();
	}
	
	private void addNewPayment(CashPayment payment) {
		double amountToAdd = payment.getPaidAmount().getAmount(); 
		double newTotalRevenue = totalRevenue.getAmount() + amountToAdd;
		this.totalRevenue = new Amount(newTotalRevenue); 
	}
	
	private void printCurrentState() {
		System.out.println("\nTotal revenue: ");
		System.out.println(this.totalRevenue.getAmount());
		System.out.println();
	}
}
