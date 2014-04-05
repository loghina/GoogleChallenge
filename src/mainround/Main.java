package mainround;
import java.util.List;

import mainround.algorithms.*;
import mainround.entities.Car;
import mainround.entities.Problem;


public class Main {

	public static void main(String[] args) {
		
		// Input
		//String filename = "example2.txt";
		String filename = "paris_54000.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Problem input = Input.read(filename);
		
		// Algorithme
		Algorithm algo = new Algorithm1();
		//Algorithm algo = new Algorithm2();
		List<Car> solution = algo.calculate(input);
		
		AlgorithmAlex algo_2 = new AlgorithmAlex();
		List<Car> solution_alex = algo_2.calculate(input);
		
		// Output
		System.out.println(Output.getOutput(solution));
		
		// Test
		
	}
}
