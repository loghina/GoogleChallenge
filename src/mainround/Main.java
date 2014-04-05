package mainround;
import java.util.List;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

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
		
		// Algorithme1
		Algorithm1 algo = new Algorithm1();
		algo.calculate(input);
		//Algorithm algo = new Algorithm2();
		List<Car> solution = algo.calculate(input);
		
		AlgorithmAlex algo_2 = new AlgorithmAlex();
		List<Car> solution_alex = algo_2.calculate(input);
		
		// Output
		System.out.println(Output.getOutput(solution));
		
		// Test
		ICombinatoricsVector<String> initialVector = Factory.createVector(
				new String[] { "red", "black", "white", "green", "blue" } );
		Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 3);
		System.out.println("nombre de combinaisons"+gen.getNumberOfGeneratedObjects());
		
	}
}