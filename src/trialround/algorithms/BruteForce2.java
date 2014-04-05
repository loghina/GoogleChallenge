package trialround.algorithms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import trialround.Image;
import trialround.action.Action;
import trialround.action.EraseCell;
import trialround.action.PaintSQ;


public class BruteForce2 {

	private class SquareGain extends PaintSQ implements Comparable<SquareGain> {
		public int gain;
		
		@Override
		public int compareTo(SquareGain a) {
			return S == a.S ? 0 : a.gain - gain;
		}
	}

	public List<Action> calculate(Image im) {
		int[][] workingImage = new int[im.rows][im.columns];
		List<Action> result = new ArrayList<Action>();
		
		int[][] bestS = new int[im.rows][im.columns];
		int[][] gainS = new int[im.rows][im.columns];
		
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				workingImage[row][column] = 0;
				
				int maxdim = column < row ? column : row;
				int dr = im.rows - row - 1;
				int dc = im.columns - column - 1;
				maxdim = maxdim < dr ? maxdim : dr;
				maxdim = maxdim < dc ? maxdim : dc;
				bestS[row][column] = 0;
				gainS[row][column] = -1;
				
				for(int s=maxdim-1; s>=0; s--) {
					int count = im.countSetPoints(row, column, s);
					int cost = (2*s+1)*(2*s+1) - count + 1;
					// cost
					int gain = count - cost; 
					//if(cost > count) continue;
					
					// update
					if(gain > gainS[row][column]) {
						bestS[row][column] = s;
						gainS[row][column] = gain;
					}
				}
			}
		}

		PriorityQueue<SquareGain> queue = new PriorityQueue<SquareGain>();
		// fill priority queue
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				if(bestS[row][column] > 0 && gainS[row][column] > 0) {
					SquareGain s = new SquareGain();
					s.C = column;
					s.R = row;
					s.S = bestS[row][column];
					s.gain = gainS[row][column];
					queue.add(s);
				}
			}
		}

		// print debug
		/*for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				System.out.print(bestS[row][column] + " (" + gainS[row][column] + ") " + ", ");
			}
			System.out.println();
		}*/

		int tmp = 0;
		while(!queue.isEmpty()) {
			SquareGain s = queue.poll();
			if(tmp++ % 50 == 0) {
				System.err.println("queue size: " + queue.size() + " S:" + s + " result size " + result.size());
			}

			// calculate gain
			int gain = -1;
			int C2 = s.C + s.S + 1;
			int R2 = s.R + s.S + 1;
			
			int C1 = s.C - s.S;
			int R1 = s.R - s.S;
			
			for(int r=R1; r<R2; r++) {
				for(int c=C1; c<C2; c++) {
					if(im.image[r][c]) {
						gain += (workingImage[r][c] > 0) ? 0 : 1;
					}
					else {
						gain += (workingImage[r][c] >= 0) ? -1 : 0;
					}
				}
			}
			
			if(gain >= 0) {
				
				
				workingImage = s.apply(workingImage);
				result.add(s);
			}
		}

		// last step, add missing pixels, remove superfluous ones
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				if((workingImage[row][column] > 0 ? true : false) != im.image[row][column]) {
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
		
		
		return result;
	}
	
}
