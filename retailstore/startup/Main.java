package retailstore.startup;

import retailstore.view.View;
import retailstore.controller.Controller;
import retailstore.integration.RegistryCreator;
import retailstore.integration.Printer;
/**
 * 
 * @author User
 *
 */
public class Main {
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		RegistryCreator creator = new RegistryCreator();
		
		Printer printer = new Printer();
		
		Controller contr = new Controller(creator);
		
		View view = new View(contr);
		
		view.sampleExecution();
	}
	
}
