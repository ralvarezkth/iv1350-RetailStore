package retailstore.view;

import retailstore.controller.Controller;
import retailstore.model.SaleDTO;
import retailstore.integration.Amount;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.CustomerIDDTO;;

/**
 * This program has no view, instead, this class is a placeholder for the entire view.
 */
public class View {
	private Controller contr;

	/**
	 * Creates an instance
	 *
	 * @param contr	The controller that is used for all operations.
	 */
	public View (Controller contr) {
		this.contr = contr;
	}

	/**
	 * Simulates a user input that generates calls to all system operations.
	 */
	public void sampleExecution() {
		contr.startNewSale();
		System.out.println("New sale started.");
		System.out.println("Ready to scan items.");
		System.out.println();

		ItemIdentifierDTO firstValidItemIdentifier = new ItemIdentifierDTO("0123456789");
		ItemIdentifierDTO secondValidItemIdentifier = new ItemIdentifierDTO("1231231231");
		ItemIdentifierDTO invalidItemIdentifier = new ItemIdentifierDTO("0000000000");

		SaleDTO currentSaleDTO = contr.enterIdentifier(firstValidItemIdentifier, 1);
		if (currentSaleDTO == null) {
			System.out.println("No item was found.");
		}
		else {
			System.out.println("Item name: " + currentSaleDTO.getFoundItem().getName());
			System.out.printf("Item price: " + "%.2f\n", currentSaleDTO.getFoundItem().getPrice().getAmount());
			System.out.printf("Item VAT rate: " + "%.0f" + "%%\n", currentSaleDTO.getFoundItem().getVATrate().getAmount());
			System.out.println();
			System.out.printf("Running total (including VAT): " + "%.2f\n", currentSaleDTO.getRunningTotal().getAmount());
		}
		System.out.println();
		System.out.println();
		System.out.println("Ready to scan items.");
		System.out.println();

		currentSaleDTO = contr.enterIdentifier(secondValidItemIdentifier, 4);
		if (currentSaleDTO == null) {
			System.out.println("No item was found.");
		}
		else {
			System.out.println("Item name: " + currentSaleDTO.getFoundItem().getName());
			System.out.printf("Item price: " + "%.2f\n", currentSaleDTO.getFoundItem().getPrice().getAmount());
			System.out.printf("Item VAT rate: " + "%.0f" + "%%\n", currentSaleDTO.getFoundItem().getVATrate().getAmount());
			System.out.println();
			System.out.printf("Running total (including VAT): " + "%.2f\n", currentSaleDTO.getRunningTotal().getAmount());
		}
		System.out.println();
		System.out.println();
		System.out.println("Ready to scan items.");
		System.out.println();

		currentSaleDTO = contr.enterIdentifier(invalidItemIdentifier, 1);
		if (currentSaleDTO == null) {
			System.out.println("No item was found.");
		}
		else {

			System.out.println("Item name: " + currentSaleDTO.getFoundItem().getName());
			System.out.printf("Item price: " + "%.2f\n", currentSaleDTO.getFoundItem().getPrice().getAmount());
			System.out.printf("Item VAT rate: " + "%.0f" + "%%\n", currentSaleDTO.getFoundItem().getVATrate().getAmount());
			System.out.println();
			System.out.printf("Running total: " + "%.2f\n", currentSaleDTO.getRunningTotal().getAmount());
		}
		System.out.println();
		System.out.println("Ready to scan items.");
		System.out.println();

		Amount totalPrice = contr.signalFinished();
		System.out.println("Scanning finished.");
		System.out.println();
		System.out.printf("Total price: " + "%.2f\n", totalPrice.getAmount());

		CustomerIDDTO exampleCustomerWithDiscount = new CustomerIDDTO("Ellinor", 999999);

		Amount priceAfterDiscountRequestForAria = contr.discountRequest(exampleCustomerWithDiscount);
		if (priceAfterDiscountRequestForAria.getAmount() == totalPrice.getAmount()) {
			System.out.println("Not eligible for a discount.");		}
		else {
			System.out.printf("Total price with discount: " + "%.2f\n", priceAfterDiscountRequestForAria.getAmount());
		}
		System.out.println();

		Amount paidAmount = new Amount(1000);

		Amount change = contr.enterPaidAmount(paidAmount);
		System.out.println();
		System.out.printf("Change: " + "%.2f\n", change.getAmount());
		System.out.println();
		System.out.println("Thank you, please come again!");
		System.out.println("Remember to add that alternative flow you forgot :)");
	}

}
