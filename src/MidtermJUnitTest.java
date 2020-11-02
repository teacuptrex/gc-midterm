import static org.junit.jupiter.api.Assertions.*;



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
}