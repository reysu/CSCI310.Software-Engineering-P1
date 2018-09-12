import java.io.*;
import java.util.Scanner;

public class SearchMap {
	
	public static void main(String args[]) {
		if(0 < args.length) {
			String inputFileName = args[0] + ".txt";
		//	File inputFile = new File(inputFileName);
		//	String outputFileName = args[1];
		//	File outputFile = new File(outputFileName);
			
			try {
				Scanner inputReader = new Scanner(new FileInputStream(inputFileName));
				while(inputReader.hasNextLine()) {
					System.out.println(inputReader.nextLine());
				}
				inputReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("no");
			}
		}else {
			System.out.println("Please enter a input file.");
		}
	}
}