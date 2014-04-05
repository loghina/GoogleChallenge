package mainround;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Input {

	// TODO: output type
	public static Object read(String filename) {
		Object result = null;
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return result;
		}
		
		try {
			String size = reader.readLine();
			if(size == null) {
				System.out.println("not enough input, size missing");
				reader.close();
				return result;
			}
			
			// TODO: parsing
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
	}
}
