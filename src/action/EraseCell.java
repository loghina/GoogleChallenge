package action;

public class EraseCell implements Action {
	public int R = 0;
	public int C = 0;
	
	@Override
	public void apply(boolean[][] image) {
		// TODO Auto-generated method stub
		
		image[R][C] = false;
	}
	
	public String toString() {
		return "ERASECELL " + R + " " + C;
	}
}
