
public class Algo1 {
	Image myImage;
	public Algo1(Image im){
		myImage=im;
	}
	
	public void Elaborate(){
		int nr_squares, c_row=0,c_col=0;
		//check the best square to paint for the central point
		if (myImage.height<myImage.width){
			nr_squares=myImage.width/myImage.height;
			c_col=myImage.height/2;
			for (int i=0;i<nr_squares;i++){
				c_row=myImage.width/2;
				c_col+=myImage.height;
				CheckBestPaint(c_row,c_col);
			}
			
		}else{
			nr_squares=myImage.height/myImage.width;
			c_row=myImage.width/2;
			for (int i=0;i<nr_squares;i++){
				c_row+=myImage.width;
				c_col=myImage.height/2;
				CheckBestPaint(c_row,c_col);
			}
		}
	}
	
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
