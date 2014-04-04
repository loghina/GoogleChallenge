import java.util.List;

import action.Action;
import action.Painter;


public class Main {

	public static void main(String[] args) {
		
		// Input
		String filename = "doodle.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Image im = ImageReader.read(filename);
		
		// Algorithme
		Simple s = new Simple();
		List<Action> action = s.calculate(im);
		
		// Output
		System.out.println(Painter.getOutput(action));
	}
}
