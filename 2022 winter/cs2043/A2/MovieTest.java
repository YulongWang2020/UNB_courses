package assn2.yw;

import java.security.InvalidParameterException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import assn2.yw.Movie;

import org.junit.jupiter.api.Test;

public class MovieTest {
	
	@ParameterizedTest
	@ValueSource(ints = {10, -10})
	void testAddRateException(int rate) {
		Movie m = new Movie("m");
		Exception exception = assertThrows(
				InvalidParameterException.class,
				() -> m.addRate(rate)
	     );
		assertEquals("Rate must be a integer from 0 to 5",exception.getMessage());
	}
	
	@Test
	void testnullAvgRate() {
		Movie m = new Movie("m");
		assertEquals(null,m.getAvgRate());
	}
	
	@Test
	void testAvgRate() {
		Movie m = new Movie("m");
		m.addRate(5);
		m.addRate(0);
		assertEquals(2.5,m.getAvgRate());
	}
	
	@Test
	void testclearRate() {
		Movie m = new Movie("m");
		m.addRate(5);
		m.addRate(0);
		m.clearRates();
		assertEquals(null,m.getAvgRate());
	}
 
	
}
