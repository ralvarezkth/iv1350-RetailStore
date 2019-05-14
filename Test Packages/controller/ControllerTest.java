package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import retailstore.controller.Controller;
import retailstore.controller.OperationFailedException;
import retailstore.integration.Amount;
import retailstore.integration.ItemDTO;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.ItemRegistry;
import retailstore.integration.Printer;
import retailstore.integration.RegistryCreator;

class ControllerTest {

	protected Controller testController;
	protected ItemRegistry itemReg;
	protected ItemDTO searchedItemForDatabaseError;
	protected ItemDTO searchedItemForIdentifierError;
	protected RegistryCreator testCreator = new RegistryCreator();
	protected Printer testPrinter = new Printer();
	
	
	@BeforeEach
	void setUp() throws Exception {
		testController = new Controller(testCreator, testPrinter);
		searchedItemForDatabaseError = new ItemDTO(new Amount(0), new Amount(0), " ", new ItemIdentifierDTO("-1"));
		searchedItemForIdentifierError = new ItemDTO(new Amount(0), new Amount(0), " ", new ItemIdentifierDTO("0"));
	}

	@AfterEach
	void tearDown() throws Exception {
		testController = null;
		searchedItemForDatabaseError = null;
		searchedItemForIdentifierError = null;
	}

	@Test
	void testEnterIdentifierWithAnInvalidIdentifier() throws OperationFailedException {
		String expectedMsg = ("Item with identifier " + searchedItemForIdentifierError.getItemIdentifierDTO().getItemIdentifier() + " was not found.");
		
		try {
			testController.enterIdentifier(searchedItemForIdentifierError.getItemIdentifierDTO());
			fail("Works with an identifier that does not exist.");
		}
		catch (OperationFailedException exc) {
			assertEquals(expectedMsg, exc.getMessage(), "Wrong exception message, does not contain specified item identifier: ");
		}
	}
	
	@Test
	void testEnterIdentifierWithDatabaseFailureIdentifier() throws OperationFailedException {
		String expectedMsg = ("Unable to connect to the database...");
		
		try {
			testController.enterIdentifier(searchedItemForDatabaseError.getItemIdentifierDTO());
			fail("Works without a database connection");
		}
		catch (OperationFailedException exc) {
			assertEquals(expectedMsg, exc.getMessage(), "Wrong exception message, does not contain specified item identifier: ");
		}
	}
}
