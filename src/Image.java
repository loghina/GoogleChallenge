
public class Image {

	public int rows;
	public int columns;
	public boolean image[][];
	
	private int integralImage[][];
	
	public Image(int width, int height, boolean image[][]) {
		this.columns = width;
		this.rows = height;
		this.image = image;
		
		calculateIntegralImage();
	}
	
	private void calculateIntegralImage() {
		if(integralImage != null) {
			return;
		}
		integralImage = new int[rows][columns];
		
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				if(column>0) {
					integralImage[row][column] += integralImage[row][column-1];
				}
				if(row>0) {
					integralImage[row][column] += integralImage[row-1][column];
				}
				if(column>0 && row>0) {
					integralImage[row][column] -= integralImage[row-1][column-1];
				}
				
				integralImage[row][column] += image[row][column] ? 1 : 0;
			}
		}
	}
	
	
	
	
	public int countSetPoints(int row, int column, int s) {
		String warning = "Warning: countSetPoints request outside of image";
		
		int column2 = column + s;
		if(column2 >= columns) {
			System.out.println(warning);
			column2 = columns-1;
		}
		int row2 = row + s;
		if(row2 >= rows) {
			System.out.println(warning);
			row2 = rows-1;
		}
		
		int column1 = column - s - 1;
		int row1 = row - s - 1;
		
		if(column1 < 0 && row1 < 0) {
			if(column1 < -1 || row1 < -1) {
				System.out.println(warning);
			}
			return integralImage[row2][column2];
		}
		
		if(column1 < 0) {
			System.out.println(warning);
			column1 = 0;
		}
		if(row1 < 0) {
			System.out.println(warning);
			row1 = 0;
		}
		
		return integralImage[row2][column2] - integralImage[row2][column1] - integralImage[row1][column2] + integralImage[row1][column1];
	}
	
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(rows + " " + columns);
		builder.append("\n");
		
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				if(image[row][column]) {
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
		int fieldlength = (int)Math.ceil(Math.log10(integralImage[rows-1][columns-1])) + 1;
		//System.out.println(fieldlength);
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				System.out.printf("%" + fieldlength + "d, ", integralImage[row][column]);
			}
			System.out.println();
		}
	}
}
