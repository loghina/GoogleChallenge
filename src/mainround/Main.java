package mainround;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import mainround.algorithms.*;
import mainround.entities.Car;
import mainround.entities.Problem;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		// Input
		//String filename = "example2.txt";
		String filename = "paris_54000.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Problem input = Input.read(filename);
		
		// Algorithme
		//Algorithm algo = new AlgorithmRandom();
		//Algorithm algo = new Algorithm2();
		//List<Car> solution = algo.calculate(input);
		
		AlgorithmAlex algo_2 = new AlgorithmAlex();
		List<Car> solution_alex = algo_2.calculate(input);
		
		// Output
		String output = Output.getOutput(solution_alex);
		//System.out.println(output);
		
		String outputfilename = "output.txt";
		PrintWriter printer;
		try {
			printer = new PrintWriter(outputfilename);
			printer.print(output);
			printer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Test
		
		System.err.println(Output.getScore(solution_alex));
	}
}
