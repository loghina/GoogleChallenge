
public class Algo1 {
	Image myImage;
	public Algo1(Image im){
		myImage=im;
	}
	
	/*public void Elaborate(){
		int nr_squares, c_row=0,c_col=0;
		//check the best square to paint for the central point
		if (myImage.rows<myImage.columns){
			nr_squares=myImage.columns/myImage.rows;
			c_col=myImage.rows/2;
			for (int i=0;i<nr_squares;i++){
				c_row=myImage.columns/2;
				c_col+=myImage.rows;
				CheckBestPaint(c_row,c_col);
			}
			
		}else{
			nr_squares=myImage.rows/myImage.columns;
			c_row=myImage.columns/2;
			for (int i=0;i<nr_squares;i++){
				c_row+=myImage.columns;
				c_col=myImage.rows/2;
				CheckBestPaint(c_row,c_col);
			}
		}
	}*/
	
	public int CheckBestPaint(int row, int col){
		int s=0,best_points=0,points=0;
		for (s=0;s<row;s++){
			points=myImage.countSetPoints(row, col, s);
			if (points>best_points)
				best_points=points;
		}
		return s;
	}
}
