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
	
	public void VisitIntersection(Intersection inters){
		intersections.add(inters);
	}
}