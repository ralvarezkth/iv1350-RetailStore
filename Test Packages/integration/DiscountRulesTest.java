package integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import retailstore.integration.Amount;
import retailstore.integration.CustomerIDDTO;
import retailstore.integration.DiscountRules;
import retailstore.integration.RegistryCreator;
/**
 * Tests for the DiscountRules class.
 *
 */
class DiscountRulesTest {
	protected Amount testTotalPrice;
	protected Amount testDiscountPercentage;
	protected DiscountRules testDiscountRules;
	protected RegistryCreator testCreator;
	protected CustomerIDDTO testCustomerWithDiscount = 
			new CustomerIDDTO("testPersonWithDiscount", 555555);
	protected CustomerIDDTO testCustomerWithoutDiscount = 
			new CustomerIDDTO("testPersonWithoutDiscount", 555554);

	@BeforeEach
	void setUp() {
		testCreator = new RegistryCreator();
		testDiscountRules = testCreator.getDiscountRules();
		testTotalPrice = new Amount(100);
		testDiscountPercentage = new Amount(0.1);
	}

	@AfterEach
	void tearDown() {
		testTotalPrice = null;
		testDiscountPercentage = null;
		testDiscountRules = null;
		testCustomerWithDiscount = null;
		testCustomerWithoutDiscount = null;
	}

	@Test
	void testCalculatePriceWithDiscount() {
		testDiscountRules = testDiscountRules
				.checkRules(testCustomerWithDiscount);
		double expResult = new Amount(90).getAmount();
		double result = this.testTotalPrice.getAmount() 
				* (1 - testDiscountRules.getDiscountPercentage().getAmount());
		assertEquals(expResult, result, "Calculations are incorrect");
	}
	
	@Test
	void testCalculatePriceWithoutDiscount() {
		testDiscountRules = testDiscountRules
				.checkRules(testCustomerWithoutDiscount);
		double expResult = new Amount(100).getAmount();
		double result = this.testTotalPrice.getAmount() 
				* (1 - testDiscountRules.getDiscountPercentage().getAmount());
		assertEquals(expResult, result, "Calculations are incorrect.");
	}

}
