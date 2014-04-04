import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import action.Action;
import action.Painter;


public class Main {

	public static void main(String[] args) {
		
		// Input
		String filename = "example.txt";
		if(args.length > 0) {
			filename = args[0];
		}
		Image im = ImageReader.read(filename);
		
		// Algorithme
		//Simple s = new Simple();
		//List<Action> action = s.calculate(im);
		
		Solver so = new Solver();
		so.Solve(im);
		
		
		// Output
		//System.out.println(Painter.getOutput());
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter( "output.txt"));
		    writer.write( Painter.getOutputPaint(so.painters));
		    writer.write( Painter.getOutputErase(so.erasers));

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}
}
