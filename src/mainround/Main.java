package mainround;
import java.util.List;

import mainround.algorithms.*;


public class Main {

	public static void main(String[] args) {
		
		// Input
		//String filename = "example2.txt";
		String filename = "example.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Object input = Input.read(filename);
		
		// Algorithme
		Algorithm algo = new Algorithm1();
		//Algorithm algo = new Algorithm2();
		Object solution = algo.calculate(input);
		
		// Output
		System.out.println(Output.getOutput(solution));
		
		// Test
		
	}
}
