package trialround.action;

public class PaintSQ implements Action{

	public int R;
	public int C;
	
	public int S;
	
	@Override
	public boolean[][] apply(boolean image[][]) {
		
		int R1 = R - S;
		int R2 = R + S + 1;
		int C1 = C - S;
		int C2 = C + S + 1;
		
		if(R1 < 0 || C1 < 0 || R2 > image.length || C2 > image[0].length) {
			System.out.println("PaintSQ violated boundaries");
			throw new UnsupportedOperationException("R " + R + " C " + C + " S " + S);
		}

		for(int row=R1; row<R2; row++) {
			for(int column=C1; column<C2; column++) {
				image[row][column] = true;
			}
		}
		
		return image;
	}

	/**
	 * applies +1 to all pixel with values >= 0
	 */
	@Override
	public int[][] apply(int image[][]) {
		
		int R1 = R - S;
		int R2 = R + S + 1;
		int C1 = C - S;
		int C2 = C + S + 1;
		
		if(R1 < 0 || C1 < 0 || R2 > image.length || C2 > image[0].length) {
			System.out.println("PaintSQ violated boundaries");
			throw new UnsupportedOperationException();
		}

		for(int row=R1; row<R2; row++) {
			for(int column=C1; column<C2; column++) {
				if(image[row][column] >= 0 ) {
					image[row][column] += 1;
				}
			}
		}
		
		return image;
	}
	
	public String toString() {
		return "PAINTSQ " + R + " " + C + " " + S;
	}
}
