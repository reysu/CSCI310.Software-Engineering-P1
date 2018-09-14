import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightMap {
	private int numLocations;
	private int[][] flights; 
	private List<Character> cities; 
	/* Performs DFS to populate numLocations */
	public FlightMap(String inputFile) throws IOException {
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
		flights = new int[numLocations][numLocations];
		storeMap(inputFile);
		inputReader.close();
	}
	private void storeMap(String inputFile) {
		Scanner inputReader = new Scanner(inputFile);
		String currLine;
		while(inputReader.hasNextLine()){
			currLine = inputReader.nextLine();
			char currChar;
			int cityFrom,cityTo;
			cityFrom = cities.indexOf(currLine.charAt(0));
			cityTo = cities.indexOf(currLine.charAt(2));
			Scanner s = new Scanner(currLine);
//			System.out.println(s.nextInt());
			flights[cityFrom][cityTo] = Integer.parseInt(currLine.replaceAll("[\\D]", ""));
		}
		
		/*
		System.out.print("   ");
		for(int i=0;i<numLocations;i++) {
			System.out.print(cities.get(i) + "  ");
		}
		System.out.println("");
		for(int i=0;i<numLocations;i++) {
			System.out.print(cities.get(i) + "  ");
			for(int j=0;j<numLocations;j++) {
				System.out.print(flights[i][j] + "  ");
			}
			System.out.println("");
		}
		*/
	}
	public int getNumLocations() {
		return numLocations; 
	}
	public int[][] getFlights() {
		return flights;
	}

	public void setFlights(int[][] flights) {
		this.flights = flights;
	}
	
}
