package integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import retailstore.integration.Amount;
import retailstore.integration.DatabaseConnectionFailureException;
import retailstore.integration.InvalidIdentifierException;
import retailstore.integration.ItemDTO;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.ItemRegistry;
import retailstore.integration.RegistryCreator;

class ItemRegistryTest {
	
	protected ItemRegistry itemReg;
	protected RegistryCreator testCreator;
	protected ItemDTO SearchedItemForDatabaseError;
	protected ItemDTO SearchedItemForIdentifierError;
	
	
	@BeforeEach
	void setUp() {
		testCreator = new RegistryCreator();
		itemReg = testCreator.getItemRegistry();
		SearchedItemForDatabaseError = new ItemDTO(new Amount(0), new Amount(0), " ", new ItemIdentifierDTO("-1"));
		SearchedItemForIdentifierError = new ItemDTO(new Amount(0), new Amount(0), " ", new ItemIdentifierDTO("0"));
	}

	@AfterEach
	void tearDown() {
		testCreator = null;
		itemReg = null;
		SearchedItemForDatabaseError = null;
		SearchedItemForIdentifierError = null;
		
	}
	
	@Test
	void testFindItemWithAnInvalidIdentifier() throws InvalidIdentifierException, DatabaseConnectionFailureException {
		String expectedMsg = ("Item with identifier " + SearchedItemForIdentifierError.getItemIdentifierDTO().getItemIdentifier() + " was not found.");
		
		try {
			itemReg.findItem(SearchedItemForIdentifierError.getItemIdentifierDTO());
			fail("Could find an item with an identifier that does not exist.");
		}
		catch (InvalidIdentifierException exc) {
			assertEquals(expectedMsg, exc.getMessage(), "Wrong exception message, does not contain specified item identifier: ");
		}
	}
	
	@Test
	void testFindItemDatabaseFailureException() throws InvalidIdentifierException, DatabaseConnectionFailureException {
		String expectedMsg = "Unable to connect to the database...";
		
		try {
			itemReg.findItem(SearchedItemForDatabaseError.getItemIdentifierDTO());
			fail("Could find an item with an identifier that does not exist.");
		}
		catch (DatabaseConnectionFailureException exc) {
			assertEquals(expectedMsg, exc.getMessage(), "Wrong exception message, able to connect to the database.");
		}
	}

}
