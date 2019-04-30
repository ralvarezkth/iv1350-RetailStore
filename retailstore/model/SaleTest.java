package retailstore.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import retailstore.integration.Amount;
/**
 * Tests for the Sale class.
 *
 */
class SaleTest {
	protected Amount firstAmount;
	protected Amount secondAmount;
	
	
	@BeforeEach
	void setUp() {
		firstAmount = new Amount(3);
		secondAmount = new Amount(3);
		
	}

	@AfterEach
	void tearDown() {
		firstAmount = null;
		secondAmount = null;
		
	}

	@Test
	void testSubtractionOfPayMethod() {
		double expResult = new Amount(0).getAmount();
		double result = new Amount(firstAmount.getAmount()
				- secondAmount.getAmount()).getAmount();
		assertEquals(expResult, result, "Calculations are incorrect");
	}
	
	

}
