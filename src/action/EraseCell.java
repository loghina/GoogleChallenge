package action;

public class EraseCell implements Action {
	public int R = 0;
	public int C = 0;
	
	public EraseCell(int _R,int _C)
	{
		R=_R;
		C=_C;
	}
	
	@Override
	public void apply(boolean[][] image) {
		// TODO Auto-generated method stub
		
		image[R][C] = false;
	}
	
	public String toString() {
		return "ERASECELL " + R + " " + C;
	}
}
