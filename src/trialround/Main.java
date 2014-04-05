package trialround;
import java.util.List;

import trialround.action.Action;
import trialround.algorithms.BruteForce3;


public class Main {

	public static void main(String[] args) {
		
		// Input
		//String filename = "example2.txt";
		String filename = "example.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Image im = ImageReader.read(filename);
		
		// Algorithme
		//Simple algo = new Simple();
		BruteForce3 algo = new BruteForce3();
		List<Action> actions = algo.calculate(im);
		
		// Output
		System.out.println(Painter.getOutput(actions));
		
		// Test
		Image imnew = new Image(im.rows, im.columns);
		Painter.paint(actions, imnew);
		//System.out.println(im);
		/*System.out.println(imnew);*/
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				if(imnew.image[row][column] != im.image[row][column]) {
					System.out.println("resulting image is not correct at " + row + "," + column);
				}
			}
		}
	}
}
