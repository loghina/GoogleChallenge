
public class Image {

	public final int height;
	public final int width;
	public final boolean image[][];
	
	private int integralImage[][];
	
	public Image(int width, int height, boolean image[][]) {
		this.width = width;
		this.height = height;
		this.image = image;
		
		calculateIntegralImage();
	}
	
	private void calculateIntegralImage() {
		if(integralImage != null) {
			return;
		}
		integralImage = new int[width][height];
		
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				if(x>0) {
					integralImage[x][y] += integralImage[x-1][y];
				}
				if(y>0) {
					integralImage[x][y] += integralImage[x][y-1];
				}
				if(x>0 && y>0) {
					integralImage[x][y] -= integralImage[x-1][y-1];
				}
				
				integralImage[x][y] += image[x][y] ? 1 : 0;
			}
		}
	}
	
	public int countSetPoints(int x, int y, int s) {
		String warning = "Warning: countSetPoints request outside of image";
		
		int x2 = x + s;
		if(x2 >= width) {
			System.out.println(warning);
			x2 = width-1;
		}
		int y2 = y + s;
		if(y2 >= height) {
			System.out.println(warning);
			y2 = height-1;
		}
		
		int x1 = x - s - 1;
		int y1 = y - s - 1;
		
		if(x1 < 0 && y1 < 0) {
			System.out.println(warning);
			return integralImage[x2][y2];
		}
		
		if(x1 < 0) {
			System.out.println(warning);
			x1 = 0;
		}
		if(y1 < 0) {
			System.out.println(warning);
			y1 = 0;
		}
		
		return integralImage[x2][y2] - integralImage[x1][y2] - integralImage[x2][y1] + integralImage[x1][y1];
	}
	
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
	
	public void debugIntegralImage() {
		int fieldlength = (int)Math.ceil(Math.log10(integralImage[width-1][height-1])) + 1;
		//System.out.println(fieldlength);
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				System.out.printf("%" + fieldlength + "d, ", integralImage[x][y]);
			}
			System.out.println();
		}
	}
}
