import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SearchMap {
	
	public static void main(String args[]) {
		if(0 < args.length) {
			String inputFileName = args[0] + ".txt";
			String outputFileName = args[1] + ".txt";
			try {
				Scanner inputReader = new Scanner(new FileInputStream(inputFileName));
				String inputFile = "";
				String startPoint = inputReader.nextLine();
				/*comment or uncomment this line if u want the first line to be passed in */
				//inputFile = startPoint + "\n";
				while(inputReader.hasNextLine()) {
					
					inputFile = inputFile + inputReader.nextLine() + "\n";
					
				}
				inputReader.close();
				FlightMap map = new FlightMap(inputFile);
				System.out.println(map.getNumLocations());
				
				
				
				try {
					FileWriter output = new FileWriter(new File(outputFileName));
					PrintWriter printWriter = new PrintWriter(output);
					printWriter.write("Destination\t Flight Route from "+ startPoint +"\t Total Cost");
					printWriter.close();
					
				} catch (IOException e) {
				} 
			} catch (IOException e) {
			
			}
		}else {
			System.out.println("Please enter a input file.");
		}
	}
}