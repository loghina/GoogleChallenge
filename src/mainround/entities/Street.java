package mainround.entities;


public class Street {
	public Intersection A, B;
	public int direction;
	public int cost;
	public int length;
	
	public Street(Intersection aj, Intersection bj, int dj, int cj, int lj){
		A=aj;
		B=bj;
		direction=dj;
		cost=cj;
		length=lj;
	}
}
