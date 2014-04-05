package mainround.entities;

import java.util.ArrayList;

public class Car {
	public int length=0;	//total length the car has passed
	public int time_passed=0;
	public ArrayList<Intersection> intersections;
	
	public Car(Intersection S){
		intersections=new ArrayList<Intersection>();
		intersections.add(S);
	}
	
	public void useStreet(Street street){
		if(getActualIntersection() != street.A) {
			System.err.println("car jumps in space");
		}
		length += street.length;
		intersections.add(street.B);
	}
	
	public Intersection getActualIntersection() {
		// TODO: check if intersections is empty?
		return intersections.get(intersections.size()-1);
	}
}