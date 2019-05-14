package retailstore.startup;

import retailstore.view.ErrorMessageHandler;
import retailstore.view.View;
import retailstore.controller.Controller;
import retailstore.controller.OperationFailedException;
import retailstore.integration.RegistryCreator;
import retailstore.integration.Printer;

/**
 * Contains the <code>main</code> method. Performs all startup 
 * of the application.
 */
public class Main {

	/**
	 * Starts the application.
	 * 
	 * @param args The application does not take any command line parameters.
	 * @throws OperationFailedException 
	 */
	public static void main (String args[]) throws OperationFailedException {
		ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
		RegistryCreator creator = new RegistryCreator();
		Printer printer = new Printer();
		Controller contr = new Controller(creator, printer);
		View view = new View(contr, errorMessageHandler);
		view.sampleExecution();
		}
}
