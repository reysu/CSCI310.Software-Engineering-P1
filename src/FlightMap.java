import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FlightMap {	
	private int numLocations;			//Number of Flight Locations
	private int[][] flights;  			//Adjaceny Matrix of Flight Graph 
	private List<Character> cities; 		//List of all the cities - corresponds to Matrix
	private char start; 				//Starting City
	private String output;
	/* Performs DFS to populate numLocations */
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
	/*Stores flights into Adjaceny Matrix*/
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
	public String getOutput() {
		return output;
	}
	public void dfs() {	
		System.out.println(String.format("%1$"+10+ "s", "Destination")+
				String.format("%1$"+25+ "s", "Flight route from " + start) + 
				String.format("%1$"+20+ "s", "Total Cost ")
				);
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
					output = output + String.format("%1$"+-17+ "s",cities.get(curr))+  
							String.format("%1$"+-28+ "s",(Arrays.toString(route.toArray())))  +
							String.format("%1$"+-10+ "s","$"+getPrice(route))+ "\n";
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
				//		System.out.println("checking to see if "+ route.get(route.size()-1) + " has children");
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
	public int getPrice(List<Character> route) {
		int price = 0;
		for (int i=0;i<route.size()-1;i++) {
			int departureIndex = cities.indexOf(route.get(i));
			int arrivalIndex = cities.indexOf(route.get(i+1));
			price = price + flights[departureIndex][arrivalIndex]; 
		}
		return price;
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
