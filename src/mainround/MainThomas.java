package mainround;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import mainround.algorithms.Algorithm;
import mainround.algorithms.thomas.*;
import mainround.algorithms.thomas.global.LongLatAlgorithm;
import mainround.algorithms.thomas.local.AlgorithmRandom2;
import mainround.entities.Car;
import mainround.entities.Problem;

public class MainThomas {

	public static void main(String[] args) {
		
		// Input
		//String filename = "example2.txt";
		String filename = "paris_54000.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Problem input = Input.read(filename);
		
		// Algorithme
		Algorithm algo = new LongLatAlgorithm();
		//algo = new AlgorithmRandom2();
		List<Car> solution = algo.calculate(input);

		// Output
		String output = Output.getOutput(solution);
		System.out.println(output);
		
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
		System.out.flush();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("Thomas");
		System.err.println(Output.getScore(solution));
	}
}
