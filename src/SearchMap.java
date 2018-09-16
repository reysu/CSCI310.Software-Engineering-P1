package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class performs the file I/O for the input and output flies
 * @author Eric Su
 *
 */
public class SearchMap {
	
	public static void main(String args[]) {
		if(0 < args.length) {
			String inputFileName = args[0] + ".txt";
			String outputFileName = args[1];
			try {
				Scanner inputReader = new Scanner(new FileInputStream(inputFileName));
				String inputFile = "";
				String startPoint = inputReader.nextLine();
				while(inputReader.hasNextLine()) {
					inputFile = inputFile + inputReader.nextLine() + "\n";
				}
				inputReader.close();
				FlightMap map = new FlightMap(inputFile,startPoint);
			
				try {
					FileWriter output = new FileWriter(new File(outputFileName));
					PrintWriter printWriter = new PrintWriter(output);
					printWriter.write(map.getOutput());
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