package 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import retailstore.integration.DatabaseConnectionFailureException;
import retailstore.integration.InvalidIdentifierException;
import retailstore.integration.ItemDTO;
import retailstore.integration.ItemIdentifierDTO;
import retailstore.integration.ItemRegistry;
import retailstore.model.Sale;

class ItemRegistryTest {
	
	protected ItemRegistry itemReg;
	protected ItemDTO searchedItem;
	
	
	@BeforeEach
	void setUp() {
		itemReg = new ItemRegistry();
		searchedItem = new ItemDTO(null, null, null, new ItemIdentifierDTO("-1"));
		
	}

	@AfterEach
	void tearDown() {
		itemReg = null;
		searchedItem = null;
		
	}
	
	@Test
	void testFindItemWithAnInvalidIdentifier() throws InvalidIdentifierException {
		
		try {
			itemReg.findItem(searchedItem.getItemIdentifierDTO());
			fail("Could find an item with an identifier that does not exist.");
		}
		catch (InvalidIdentifierException exc) {
			assertTrue("Wrong exception message, does not contain specified item identifier: "
						+ exc.getMessage(),
						exc.getMessage().contains(searchedItem.getItemIdentifierDTO().getItemIdentifier()));
		}
	}
	
	@Test
	void testFindItemDatabaseFailureException() throws DatabaseConnectionFailureException {
		String expectedMsg = ("");
		
		try {
			itemReg.findItem(searchedItem.getItemIdentifierDTO());
			fail("Could find an item with an identifier that does not exist.");
		}
		catch (DatabaseConnectionFailureException exc) {
			assertEquals(expectedMsg, exc.getMessage(), "Wrong exception message...");
		}
	}

}
