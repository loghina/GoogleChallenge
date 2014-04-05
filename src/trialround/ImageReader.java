package trialround;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ImageReader {
	
	

	public static Image read(String filename) {
		Image result = null;
		
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
			int rows = Integer.parseInt(parts[0]);
			int columns = Integer.parseInt(parts[1]);
			boolean[][] image = new boolean[rows][columns];
			
			for(int row=0; row<rows; row++) {
				String line = reader.readLine();
				if(line == null) {
					System.out.println("not enough rows, y=" + row);
					reader.close();
					return result;
				}
				if(line.length() < columns) {
					System.out.println("not enough characters at row y=" + row + ", at line " + (row+1));
					reader.close();
					return result;
				}
				for(int column=0; column<columns; column++) {

					char c = line.charAt(column);
					if(c == '#') {
						image[row][column] = true;
					}
					else if(c == '.') {
						image[row][column] = false;
					}
					else {
						System.out.println("character " + c + " at row y=" + row + ", at line " + (row+1) + ", column x=" + column + " invalid");
						reader.close();
						return result;
					}
				}
			}
			
			result = new Image(rows, columns, image);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		
		
		return result;
	}
	
	
	
}
