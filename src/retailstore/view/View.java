package retailstore.view;

import java.util.ArrayList;
import java.util.List;

import retailstore.controller.Controller;
import retailstore.controller.OperationFailedException;
import retailstore.model.SaleDTO;
import retailstore.integration.Amount;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.CustomerIDDTO;
import retailstore.integration.ItemDTO;

/**
 * This program has no view, instead, this class is a placeholder for the entire view.
 */
public class View {
	private Controller contr;
	private ErrorMessageHandler errorMessageHandler;

	/**
	 * Creates a new instance.
	 *
	 * @param contr	The controller that is used for all operations.
	 */
	public View (Controller contr, ErrorMessageHandler errorMessageHandler) {
		this.contr = contr;
		this.errorMessageHandler = errorMessageHandler;
	}

	/**
	 * Simulates a user input that generates calls to the controller.
	 * @throws InvalidIdentifierException
	 */
	public void sampleExecution() throws OperationFailedException {
		contr.startNewSale();
		System.out.println("New sale started.\n");

		List<ItemIdentifierDTO> sampleScannedItems = new ArrayList<>();

		sampleScannedItems.add(new ItemIdentifierDTO("0123456789"));
		sampleScannedItems.add(new ItemIdentifierDTO("1231231231"));
		sampleScannedItems.add(new ItemIdentifierDTO("0000000000"));

		SaleDTO currentSaleDTO = null;
		for(ItemIdentifierDTO item : sampleScannedItems) {
			try {
				currentSaleDTO = contr.enterIdentifier(item);
				if (currentSaleDTO != null) {
					System.out.println(currentSaleDTO.createSaleDToString());
					System.out.println();
				}
			}
			catch (OperationFailedException exc) {
				errorMessageHandler.showErrorMessage(exc.getMessage() + " Please try again.");
			}
		}
		Amount totalPrice = contr.signalFinished();
		System.out.println("\nSignaling finished...");
		System.out.printf("\nTotal price (including VAT): " + "%.2f\n", totalPrice.getAmount());

		CustomerIDDTO exampleCustomerWithDiscount = new CustomerIDDTO("Ellinor", 999999);
		Amount priceAfterDiscountRequestForEllinor = contr.discountRequest(exampleCustomerWithDiscount);
		System.out.println("\nSignaling discount request...\n");
		if (priceAfterDiscountRequestForEllinor.getAmount() == totalPrice.getAmount()) {
			System.out.println("Not eligible for a discount.");		}
		else {
			System.out.printf("Total price with discount (including VAT): " + "%.2f\n", priceAfterDiscountRequestForEllinor.getAmount());
		}

		Amount paidAmount = new Amount(1000);
		System.out.printf("\nPaid amount: " + "%.0f\n", paidAmount.getAmount());
		System.out.println();

		Amount change = contr.enterPaidAmount(paidAmount);
		System.out.printf("\nChange: " + "%.2f\n", change.getAmount());
		System.out.println("\nThank you, please come again!");
	}

}
