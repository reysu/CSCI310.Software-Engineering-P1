package src;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * This class contains JUnit tests for SearchMap class 
 * @author Eric Su
 * 
 * */
public class TestSearchMap {
	/**
	 * a JUnit test method to test file/io
	 * @throws IOException exception if there is an error 
	 */
	@Test
	public void fileIO() throws IOException {
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
		SearchMap a = new SearchMap();
		String[] arguments = new String[] {"input.txt","output.txt"};
		a.main(arguments);
		
	}
}
