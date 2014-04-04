import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ImageReader {

	public static Image read(String filename) {
		Image result = new Image();
		
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
			int height = Integer.parseInt(parts[0]);
			int width = Integer.parseInt(parts[1]);
			
			result.height = height;
			result.width = width;
			result.image = new boolean[width][height];
			
			for(int y=0; y<height; y++) {
				String line = reader.readLine();
				if(line == null) {
					System.out.println("not enough rows, y=" + y);
					reader.close();
					return result;
				}
				if(line.length() < width) {
					System.out.println("not enough characters at row y=" + y + ", at line " + (y+1));
					reader.close();
					return result;
				}
				for(int x=0; x<width; x++) {

					char c = line.charAt(x);
					if(c == '#') {
						result.image[x][y] = true;
					}
					else if(c == '.') {
						result.image[x][y] = false;
					}
					else {
						System.out.println("character " + c + " at row y=" + y + ", at line " + (y+1) + ", column x=" + x + " invalid");
						reader.close();
						return result;
					}
				}
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		
		
		return result;
	}
	
	
	
}
