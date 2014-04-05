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
		if(getActualIntersection().index != street.A.index) {
			System.err.println("car jumps in space "
					+ "from " + getActualIntersection().index + " "
					+ "using street from " + street.A.index + " to " + street.B.index);
		}
		time_passed += street.cost;
		if(!street.visited.visited) {
			length += street.length;
			street.visited.visit();
		}
		intersections.add(street.B);
	}
	
	public boolean testStreet(Street street, double maxtime) {
		if(time_passed + street.cost > maxtime) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Intersection getActualIntersection() {
		// TODO: check if intersections is empty?
		return intersections.get(intersections.size()-1);
	}
	
	public String toString() {
		return "car at " + getActualIntersection();
	}
}