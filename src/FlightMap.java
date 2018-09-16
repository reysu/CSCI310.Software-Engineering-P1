package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 * This class does depth first search and computes the cost of flight paths.
 * @author Eric Su
 * 
 * */


public class FlightMap {	
	private int numLocations;			//Number of Flight Locations
	private int[][] flights;  			//Adjaceny Matrix of Flight Graph 
	private List<Character> cities; 		//List of all the cities - corresponds to Matrix
	private char start; 					//Starting City
	private String output;				//

	/**
	 * The constructor counts number of locations and stores the graph as an adjaceny matrix
	 * @param inputFile the inputfile as a String
	 * @param startPoint	the starting point - first line in the input file
	 * @throws IOException
	 */
	public FlightMap(String inputFile,String startPoint) throws IOException {
		cities = new ArrayList<Character>();
		start = startPoint.charAt(0);
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
	/**
	 * The method stores the graph as an adjaceny matrix
	 * @param inputFile the input file as a string
	 */
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
		dfs();
	}
	/**
	 * 
	 * @return returns the output as a string
	 */
	public String getOutput() {
		return output;
	}
	/**
	 * 
	 * The method performs dfs on the adjaceny matrix and stores the result in a string
	 */
	private void dfs() {	
		output = String.format("%1$"+10+ "s", "Destination")+
				String.format("%1$"+25+ "s", "Flight route from " + start) + 
				String.format("%1$"+20+ "s", "Total Cost ") + "\n";
//		System.out.println("Destination\t" + "Flight route from " + start + "\t Total Cost");
		int indexOfStart = cities.indexOf(start);
		boolean[] visited = new boolean[numLocations];
		Stack path = new Stack(); 
		path.push(indexOfStart);
		List<Character> route = new ArrayList<Character>();
		while(!path.isEmpty()) {
			int curr = (int) path.pop();
			route.add(cities.get(curr));
			if(visited[curr] == false) {
				if(curr != 0 && curr != indexOfStart) {
					System.out.println(String.format("%1$"+-17+ "s",cities.get(curr))+  
							String.format("%1$"+-28+ "s",(Arrays.toString(route.toArray())))  +
							String.format("%1$"+-10+ "s","$"+getPrice(route)));
				}
				visited[curr] = true;
				int count = 0;
				for(int i=0; i<numLocations;i++) {
					if(flights[curr][i] != 0) {
						if(visited[i] == false) {
							path.push(i);
							count ++;
						}
					}
				}
				if(count == 0 ) {
					int prev = cities.indexOf(route.get(route.size()-1));
					int count2 = 0;
					for(int z=0; z <route.size()+1;z++) {
						for(int i=0; i<numLocations;i++) {
							if(flights[prev][i] != 0) {
								if(visited[i] == false) {
									count2++;
								}
							}
						}
						if(count2 == 0 && route.size()-1 != 0) {
							route.remove(route.size()-1);
							prev = cities.indexOf(route.get(route.size()-1));
						}
					}
				}
			}
		}
	}
	/**
	 * 
	 * @param route a list of characters that form a path on the graph
	 * @return returns the total price of a given route
	 */
	private int getPrice(List<Character> route) {
		int price = 0;
		for (int i=0;i<route.size()-1;i++) {
			int departureIndex = cities.indexOf(route.get(i));
			int arrivalIndex = cities.indexOf(route.get(i+1));
			price = price + flights[departureIndex][arrivalIndex]; 
		}
		return price;
	}
	/**
	 * 
	 * @return returns the number of locations 
	 */
	public int getNumLocations() {
		return numLocations; 
	}
	/**
	 * 
	 * @return returns the adjaceny matrix
	 */
	public int[][] getFlights() {
		return flights;
	}

}
