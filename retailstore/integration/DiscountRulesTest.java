package retailstore.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Tests for the DiscountRules class.
 *
 */
class DiscountRulesTest {
	protected Amount testTotalPrice;
	protected Amount testDiscountPercentage;
	protected DiscountRules testRulesWithDiscount = new DiscountRules();
	protected DiscountRules testRulesWithoutDiscount = new DiscountRules();
	protected CustomerIDDTO testCustomerWithDiscount = 
			new CustomerIDDTO("testPersonWithDiscount", 555555);
	protected CustomerIDDTO testCustomerWithoutDiscount = 
			new CustomerIDDTO("testPersonWithoutDiscount", 555554);

	@BeforeEach
	void setUp() {
		testTotalPrice = new Amount(100);
		testDiscountPercentage = new Amount(0.1);
		
		testRulesWithDiscount = testRulesWithDiscount
				.checkRules(testCustomerWithDiscount);
		testRulesWithoutDiscount = testRulesWithoutDiscount
				.checkRules(testCustomerWithoutDiscount);

	}

	@AfterEach
	void tearDown() {
		testTotalPrice = null;
		testDiscountPercentage = null;
		testRulesWithDiscount = null;
		testRulesWithoutDiscount = null;
		testCustomerWithDiscount = null;
		testCustomerWithoutDiscount = null;
	}

	@Test
	void testCalculatePriceWithDiscount() {
		double expResult = new Amount(90).getAmount();
		double result = this.testTotalPrice.getAmount() 
				* (1 - testRulesWithDiscount.getDiscountPercentage().getAmount());
		assertEquals(expResult, result, "Calculations are incorrect");
	}
	
	@Test
	void testCalculatePriceWithoutDiscount() {
		double expResult = new Amount(100).getAmount();
		double result = this.testTotalPrice.getAmount() 
				* (1 - testRulesWithoutDiscount.getDiscountPercentage().getAmount());
		assertEquals(expResult, result, "Calculations are incorrect.");
	}

}
