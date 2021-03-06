package trialround;

public class Image {

	public int rows;
	public int columns;
	public boolean image[][];
	
	private int integralImage[][];
	
	public Image(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
		
		this.image = new boolean[rows][columns];
		calculateIntegralImage();
	}
	
	public Image(int rows, int columns, boolean image[][]) {
		this.columns = columns;
		this.rows = rows;
		
		this.image = new boolean[rows][columns];
		for(int row=0; row<rows; row++) {
			for(int column=0; column<columns; column++) {
				this.image[row][column] = image[row][column];
			}
		}
		
		calculateIntegralImage();
	}
	
	public void calculateIntegralImage() {
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
	
	public int countSetPointsBasic(int row, int column, int s) {
		String warning = "Warning: countSetPointsBasic request outside of image r:" + row + " c:" + column + " s:" + s 
				+ "; image size rows:" + rows + " columns:" + columns;
		int column2 = column + s + 1;
		if(column2 > columns) {
			System.err.println(warning);
			column2 = columns-1;
		}
		int row2 = row + s + 1;
		if(row2 > rows) {
			System.err.println(warning);
			row2 = rows-1;
		}
		
		int column1 = column - s;
		int row1 = row - s;
		if(column1 < 0 || row1 < 0) {
				System.err.println(warning);
		}
		
		int sum = 0;
		for(int r=0; row<rows; row++) {
			for(int c=0; column<columns; column++) {
				sum += image[r][c] ? 1 : 0;
			}
		}
		
		return sum;
	}
	
	public int countSetPoints(int row, int column, int s) {
		String warning = "Warning: countSetPoints request outside of image r:" + row + " c:" + column + " s:" + s;
		
		int column2 = column + s;
		if(column2 >= columns) {
			System.err.println(warning);
			column2 = columns-1;
		}
		int row2 = row + s;
		if(row2 >= rows) {
			System.err.println(warning);
			row2 = rows-1;
		}
		
		int column1 = column - s - 1;
		int row1 = row - s - 1;
		
		if(column1 < 0 && row1 < 0) {
			if(column1 < -1 || row1 < -1) {
				System.err.println(warning);
			}
			return integralImage[row2][column2];
		}
		
		if(column1 < 0) {
			System.err.println(warning);
			column1 = 0;
		}
		if(row1 < 0) {
			System.err.println(warning);
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
