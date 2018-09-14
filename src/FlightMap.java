import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightMap {
	private int numLocations;
	private boolean[][] flights; 
	private List<Character> cities; 
	/* Performs DFS to populate numLocations */
	public FlightMap(String inputFile) throws IOException {
		//numLocations = locations;
		//setFlights(new boolean[numLocations][numLocations]);
		cities = new ArrayList<Character>();
		Scanner inputReader = new Scanner(inputFile);
		String currLine;
		char currChar;
		numLocations = 0;
		while(inputReader.hasNextLine()){
			currLine = inputReader.nextLine();
			for(int i=0;i<=2; i+=2) {
				currChar = currLine.charAt(i);
				if(!cities.contains(currChar)) {
					numLocations= numLocations + 1;
					cities.add(currChar);
				}
			}
			
		}
		inputReader.close();
	}
	public int getNumLocations() {
		return numLocations; 
	}
	public boolean[][] getFlights() {
		return flights;
	}

	public void setFlights(boolean[][] flights) {
		this.flights = flights;
	}
	
}
