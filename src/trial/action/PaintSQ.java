package trial.action;

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
			System.exit(0);
		}

		for(int row=R1; row<R2; row++) {
			for(int column=C1; column<C2; column++) {
				image[row][column] = true;
			}
		}
		
		return image;
	}
	
	public String toString() {
		return "PAINTSQ " + R + " " + C + " " + S;
	}
}
