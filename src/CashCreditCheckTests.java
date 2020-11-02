import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CashCreditCheckTests {

	@Test
	void testIsNumberValidTrue() {
			boolean expected = true;
			boolean actual = Validator.isNumberValid("5097-5647-0987-1234");
			assertEquals(expected, actual);
		
		}
	
	@Test
	void testIsNumberValidFalse() {
			boolean expected = false;
			boolean actual = Validator.isNumberValid("5097-56A7-0987-1234");
			assertEquals(expected, actual);
		
		}

}
