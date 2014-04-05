package mainround.entities;

import java.util.HashMap;

public class Intersection {
	
	public static HashMap<Integer, Intersection>  map = new HashMap<Integer, Intersection>();
	
	public double latitude, longitude;
	public int index;
	
	public Intersection() {
		
	}
	
	public String toString() {
		return "intersection " + index;
	}
}
