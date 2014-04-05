package trialround.action;

public class EraseCell implements Action {
	public int R = 0;
	public int C = 0;
	
	@Override
	public boolean[][] apply(boolean[][] image) {
		// TODO Auto-generated method stub
		
		image[R][C] = false;
		return image;
	}
	
	/**
	 * mark erased pixels with -1
	 */
	@Override
	public int[][] apply(int[][] image) {
		// TODO Auto-generated method stub
		
		image[R][C] -= 1;
		return image;
	}
	
	public String toString() {
		return "ERASECELL " + R + " " + C;
	}
}
