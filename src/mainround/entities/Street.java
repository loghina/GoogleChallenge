package mainround.entities;

import java.util.HashMap;


public class Street {
	
	public static HashMap<Integer, Street> map = new HashMap<Integer, Street>();
	
	public int index;
	
	public Intersection A, B;
	public int direction;
	public int cost;
	public int length;
	
}
