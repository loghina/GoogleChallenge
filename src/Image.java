
public class Image {

	public int height = 0;
	public int width = 0;
	public boolean image[][];
	
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(height + " " + width);
		builder.append("\n");
		
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				if(image[x][y]) {
					builder.append('#');
				}
				else {
					builder.append('.');
				}
			}
			builder.append("\n");
		}
		
		return builder.toString();
	}
}
