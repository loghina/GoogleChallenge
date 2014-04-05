package mainround;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mainround.entities.Problem;


public class Input {

	// TODO: output type
	public static Problem read(String filename) {
		Problem result = null;
		
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
			
			String parts[] = size.split(" ");
			int numberJunctions = Integer.parseInt(parts[0]);
			int numberStreets = Integer.parseInt(parts[1]);
			int timeAvailable = Integer.parseInt(parts[2]);
			int numberCars = Integer.parseInt(parts[3]);
			int startingPoint = Integer.parseInt(parts[4]);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
	}
}
