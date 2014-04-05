package trialround.algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import trialround.Image;
import trialround.action.Action;
import trialround.action.EraseCell;
import trialround.action.PaintSQ;


public class BruteForce3 {
	private class Square extends PaintSQ implements Comparable<Square> {
		@Override
		public int compareTo(Square a) {
			return S == a.S ? 0 : a.S - S;
		}
	}
	
	private class SquareGain extends PaintSQ implements Comparable<SquareGain> {
		public int diff;
		
		@Override
		public int compareTo(SquareGain a) {
			return S == a.S ? 0 : a.diff - diff;
		}
	}

	public List<Action> calculate(Image im) {
		Image imworking = new Image(im.rows, im.columns, im.image);
		List<Action> result = new ArrayList<Action>();
		PriorityQueue<Square> queue = new PriorityQueue<Square>();
		
		final int MAX = im.rows * im.columns;
		
		int[][] bestS = new int[im.rows][im.columns];
		int[][] costS = new int[im.rows][im.columns];
		
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				int maxdim = column < row ? column : row;
				int dr = im.rows - row - 1;
				int dc = im.columns - column - 1;
				maxdim = maxdim < dr ? maxdim : dr;
				maxdim = maxdim < dc ? maxdim : dc;
				costS[row][column] = MAX;
				
				for(int s=maxdim-1; s>=0; s--) {
					int count = im.countSetPoints(row, column, s);
					// cost
					int cost = 1 + ((2*s+1)*(2*s+1) - count); 
					//if(cost > count) continue;
					
					// update
					if(cost < costS[row][column]) {
						bestS[row][column] = s;
						costS[row][column] = cost;
					}
				}
			}
		}
		
		// fill priority queue
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				if(bestS[row][column] > 0 && costS[row][column] < MAX) {
					Square s = new Square();
					s.C = column;
					s.R = row;
					s.S = bestS[row][column];
					queue.add(s);
				}
			}
		}

		Image painted = new Image(im.rows, im.columns);
		// work on priority queue
		
		int actS = MAX;
		while(!queue.isEmpty()) {
			actS = queue.peek().S;
			System.err.println("queue size: " + queue.size() + " S:" + actS + " result " + result.size());
			
			PriorityQueue<SquareGain> samesizequeue = new PriorityQueue<SquareGain>();
			// find best
			while(!queue.isEmpty() && queue.peek().S == actS) {
				
				Square s = queue.poll();
				
				int impoints =  im.countSetPoints(s.R, s.C, s.S);
				int drawnpoints = 0;//painted.countSetPointsBasic(s.R, s.C, s.S);
				drawnpoints = painted.countSetPointsBasic(s.R, s.C, s.S);
				
				int diff = impoints - drawnpoints;
				//System.out.println(s + " diff " + diff);
				
				SquareGain g = new SquareGain();
				g.R = s.R;
				g.C = s.C;
				g.S = s.S;
				g.diff = diff;
				
				if(diff > 1) {
					samesizequeue.add(g);
				}
			}
			
			// choose best
			
			SquareGain g = samesizequeue.poll();
			if(g.diff > 1) {
				painted.image = g.apply(painted.image);
				result.add(g);
			}
			
			while(!samesizequeue.isEmpty()) {
				g = samesizequeue.poll();
				Square s = new Square();
				s.R = g.R;
				s.C = g.C;
				s.S = g.S;
				queue.add(s);
			}
		}
		
		// last step, add missing pixels, remove superfluous ones
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				if(painted.image[row][column] != im.image[row][column]) {
					if(im.image[row][column]) {
						PaintSQ paint = new PaintSQ();
						paint.R = row;
						paint.C = column;
						paint.S = 0;
						result.add(paint);
					}
					else {
						EraseCell erase = new EraseCell();
						erase.R = row;
						erase.C = column;
						result.add(erase);
					}
				}
			}
		}
		
		// print debug
		/*for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				System.out.print(bestS[row][column] + " (" + costS[row][column] + ") " + ", ");
			}
			System.out.println();
		}*/
		
		return result;
	}
	
}
