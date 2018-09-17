package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

/* Contains JUnit tests for FlightMap */
public class TestFlightMap {
	/**
	 * a JUnit test method to test get price of a route
	 * @throws IOException 
	 */
	@Test
	public void testGetNumLocations() throws IOException {
		String input = 
				"P W 200\n" + 
				"P R 300\n" + 
				"R X 200\n" + 
				"Q X 375\n" + 
				"W S 250\n" + 
				"S T 300\n" + 
				"T W 350\n" + 
				"W Y 500\n" + 
				"Y Z 450\n" + 
				"Y R 600\n";
		assertEquals(9,new FlightMap(input,"P").getNumLocations());
		assertEquals(1,new FlightMap("P P 0", "P").getNumLocations());
		assertEquals(2,new FlightMap("W P 200", "P").getNumLocations());
		assertEquals(5,new FlightMap("S U 200\nE F 300\nF U 200\n K E 300", "E").getNumLocations());
		assertEquals(4,new FlightMap("W P 200\nP R 300\nR Q 0", "P").getNumLocations());
	}
	
}
