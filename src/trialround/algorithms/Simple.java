package trialround.algorithms;


import java.util.ArrayList;
import java.util.List;

import trialround.Image;
import trialround.action.Action;
import trialround.action.PaintSQ;

public class Simple {

	public List<Action> calculate(Image im) {
		List<Action> result = new ArrayList<Action>();
		
		for(int row=0; row<im.rows; row++) {
			for(int column=0; column<im.columns; column++) {
				
				if(im.image[row][column]) {
					PaintSQ p = new PaintSQ();
					p.R = row;
					p.C = column;
					p.S = 0;
					result.add(p);
				}
				
			}
		}
		
		return result;
		
	}
	
}
