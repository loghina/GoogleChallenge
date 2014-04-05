package mainround.entities;

import java.util.HashMap;

public class Intersection {
	
	public static HashMap<Integer, Intersection>  map = new HashMap<Integer, Intersection>();
	
	public double latitude, longitude;
	public int index;
	static private int progressive=0;
<<<<<<< HEAD
	
	public Intersection(){index=progressive++;}
=======
	
	public Intersection() {
		
	}
	
>>>>>>> a980433041220cb9e1ef5d081bcdd6eeb9975c7d
	public Intersection(double lat, double lon){
		latitude=lat;
		longitude=lon;
		index=progressive++;
	}
	public int getIndex(){
		return index;
	}
}
