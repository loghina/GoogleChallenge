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
	
	final double earthRadius = 3958.75;
	public double distanceTo(Intersection inter) {
	    double dLat = Math.toRadians(inter.latitude-latitude);
	    double dLng = Math.toRadians(inter.longitude-longitude);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(inter.latitude)) * Math.cos(Math.toRadians(latitude)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    double meterConversion = 1609;

	    return (dist * meterConversion);
	}
}
