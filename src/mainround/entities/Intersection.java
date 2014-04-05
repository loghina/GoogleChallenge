package mainround.entities;

public class Intersection {
	public double latitude, longitude;
	public int index;
	static private int progressive=0;
	
	public Intersection(){}
	public Intersection(double lat, double lon){
		latitude=lat;
		longitude=lon;
		index=progressive++;
	}
	public int getIndex(){
		return index;
	}
}
