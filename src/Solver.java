

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import action.Action;
import action.EraseCell;
import action.PaintSQ;

public class Solver {

	ArrayList<EraseCell> erasers = new ArrayList<EraseCell>();
	ArrayList<PaintSQ> painters = new ArrayList<PaintSQ>();

	
	public int CheckBestPaint(int row, int col,Image myImage){
		int s=0,best_points=0,points=0;
		for (s=0;s<row;s++){
			points=myImage.countSetPoints(row, col, s);
			if (points>best_points)
				best_points=points;
		}
		return s;
	}
	public int score(int row,int col,int s,Image myImage)
	{
		return -(s*s)+myImage.countSetPoints(row, col, s);
	}
	
	
	public void Solve(Image img)
	{
//		boolean flags[img.columns][img.rows];
		boolean[][] flags = new boolean[img.rows][];
		for(int w = 0;w<img.rows;w++)
		{
			flags[w]=new boolean[img.columns];
		}
		PriorityQueue<Center> cells = new PriorityQueue<Center>();
		//priority queue 
		for(int r=0;r<img.rows;r++)
		{
			for(int c = 0;c<img.columns;c++)
			{
				int s = CheckBestPaint(r,c,img);
				int prio = score(r,c,s,img);
				Center cent;
				cent.setR(r);
				cent.setC(c);
				cent.setS(s);
				cent.setPriority(prio);
				cent.setFlag(false);
				flags[r][c]=false;
			   cells.add(cent);
			   //add to priority queue
			}
		}
		Center temp;
		boolean flagged=false;
		while((temp=cells.poll())!=null)
		{
			for(int k = temp.getR()-temp.getS();k<temp.getR()+temp.getS();k++)
			{
				for (int k1 = temp.getC()-temp.getS();k1<temp.getC()+temp.getS();k1++)
				{
					if(!flags[k][k1])
						{
						    
							flagged = true;
							break;
						}
					if(!img.image[k][k1])
					{
						boolean exists = false;
						for(EraseCell ec : erasers)
						{
							if(ec.R==k && ec.C==k1)
							{
								exists=true;
								break;
							}
						}
							if(!exists)
							{
								erasers.add(new EraseCell(k,k1));
							}
						
					
					}
					
				  					
				}
				if(flagged)
					break;
				
			}
			painters.add(new PaintSQ(temp.getR(),temp.getC(),temp.getS()));
		}
		
		//pop from priority queue
		//check if included or not
		//add instructions
		
		//erase instructions delete
		
		
	}
	

	
	
	
	
}
