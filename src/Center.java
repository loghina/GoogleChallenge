


public class Center implements  Comparable<Center>{
	
	int R,C;
	int S;
	int priority;
	boolean flag;
	
	
	public int getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public int getC() {
		return C;
	}
	public void setC(int c) {
		C = c;
	}
	public int getS() {
		return S;
	}
	public void setS(int s) {
		S = s;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public int compareTo(Center o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
