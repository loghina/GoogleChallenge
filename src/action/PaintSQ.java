package action;

public class PaintSQ implements Action{

	public int R;
	public int C;
	
	public int S;
	
	public PaintSQ(int _R,int _C,int _S)
	{
		R=_R;C=_C;S=_S;
	}
	
	@Override
	public void apply(boolean image[][]) {
		
		int R1 = 0;
	}
	
	public String toString() {
		return "PAINTSQ " + R + " " + C + " " + S;
	}
}
