package mainround;
import java.util.ArrayList;
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
//		String filename = "example.txt";
//		if(args.length > 0) {
//			filename = args[0];
//		}
//		Problem input = Input.read(filename);
//		
		// Algorithme
		Algorithm1 algo = new Algorithm1();
		//Algorithm algo = new Algorithm2();
		//List<Car> solution = algo.calculate(input);
		
		// Output
		//System.out.println(Output.getOutput(solution));
		
		// Test cyril
		
		ICombinatoricsVector<String> initialVector = Factory.createVector(
			      new String[] { "red", "black", "white", "green", "blue" } );
		Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 3);
		System.out.println("nombre de combinaisons"+gen.getNumberOfGeneratedObjects());
		
	}
}
