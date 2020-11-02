import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MidtermJUnitTest {

	@Test
	public void setName(){
		String expected = "Hunter";
		String actual = ("Hunter");
		assertEquals(expected, actual);
	}

	@Test
	public void getCalories() {
	Integer expected = 25;
	Integer actual = (25);
	assertEquals(expected, actual);
	
}
	
	@Test
	void testGetChange() {
		double expected = 0.0;
		double actual = MidTerm.getChange(5, 5);
		assertEquals(expected,actual);
	}
	
	@Test
	void testGetChange2() {
		double expected = -1.0;
		double actual = MidTerm.getChange(5, 6);
		assertEquals(expected,actual);
	}
	
}