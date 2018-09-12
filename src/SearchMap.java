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
				while(inputReader.hasNextLine()) {
					System.out.println(inputReader.nextLine());
				}
				inputReader.close();
				try {
					FileWriter output = new FileWriter(new File(outputFileName));
					PrintWriter printWriter = new PrintWriter(output);
					printWriter.write("Destination\t Flight Route from P\t Total Cost");
					printWriter.close();
					
				} catch (IOException e) {
				} 
			} catch (FileNotFoundException e) {
			
			}
		}else {
			System.out.println("Please enter a input file.");
		}
	}
}