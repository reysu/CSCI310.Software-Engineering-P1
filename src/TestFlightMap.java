package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains JUnit tests for FlightMap class 
 * @author Eric Su
 * 
 * */

public class TestFlightMap {
	/**
	 * a JUnit test method to test output
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
	/**
	 * a JUnit test method to test the output
	 * @throws IOException 
	 */
	@Test
	public void testOutput() throws IOException {
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
		String output = "Destination      Flight route from P         Total Cost \n" + 
				"R                [P, R]                      $300      \n" + 
				"X                [P, R, X]                   $500      \n" + 
				"W                [P, W]                      $200      \n" + 
				"Y                [P, W, Y]                   $700      \n" + 
				"Z                [P, W, Y, Z]                $1150     \n" + 
				"S                [P, W, S]                   $450      \n" + 
				"T                [P, W, S, T]                $750      \n";
		assertEquals(output,new FlightMap(input,"P").getOutput());
		input = "P X 100\n" + 
				"P Q 36\n" + 
				"X W 20\n" + 
				"X R 223\n" + 
				"Q T 5\n" + 
				"T Z 15\n" + 
				"W S 105\n" + 
				"R W 10\n" + 
				"X R 223\n" + 
				"R Y 10000";
		output = "Destination      Flight route from P         Total Cost \n" + 
				"Q                [P, Q]                      $36       \n" + 
				"T                [P, Q, T]                   $41       \n" + 
				"Z                [P, Q, T, Z]                $56       \n" + 
				"X                [P, X]                      $100      \n" + 
				"R                [P, X, R]                   $323      \n" + 
				"Y                [P, X, R, Y]                $10323    \n" + 
				"W                [P, X, R, W]                $333      \n" + 
				"S                [P, X, R, W, S]             $438      \n";
		assertEquals(output,new FlightMap(input,"P").getOutput());
		input =  "T R 1\n" + 
				"T S 3\n" + 
				"T Z 5\n" + 
				"Z L 30\n" + 
				"R G 5\n" + 
				"G A 1\n" + 
				"G B 1\n" + 
				"G C 1\n" + 
				"C T 3\n" + 
				"B Z 5\n" + 
				"M N 3\n";
		output = "Destination      Flight route from T         Total Cost \n" + 
				"Z                [T, Z]                      $5        \n" + 
				"L                [T, Z, L]                   $35       \n" + 
				"S                [T, S]                      $3        \n" + 
				"R                [T, R]                      $1        \n" + 
				"G                [T, R, G]                   $6        \n" + 
				"C                [T, R, G, C]                $7        \n" + 
				"B                [T, R, G, B]                $7        \n" + 
				"A                [T, R, G, A]                $7        \n";
		assertEquals(output,new FlightMap(input,"T").getOutput());
	}
	/**
	 * a JUnit test method to test getting price
	 * @throws IOException 
	 */
	@Test
	public void testGetPrice() throws IOException {
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
		List<Character> route = new ArrayList<Character>();
		route.add('P');
		route.add('W');
		assertEquals(200,new FlightMap(input,"P").getPrice(route));
		route.add('S');
		assertEquals(450,new FlightMap(input,"P").getPrice(route));
		route.add('T');
		assertEquals(750,new FlightMap(input,"P").getPrice(route));
		route.add('W');
		assertEquals(1100,new FlightMap(input,"P").getPrice(route));
	}
	
}
