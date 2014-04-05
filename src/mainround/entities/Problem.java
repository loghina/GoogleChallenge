
package mainround.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;

public class Problem {
	public DefaultDirectedWeightedGraph<Intersection, Street>  graph; 
	public HashSet<Street> visitedStreets;
	public float timeAvailable;
	public int numberOfCars;
	public int startingIntersection;
	
	public void setVisitedStreets(int n_streets){
		visitedStreets=new HashSet<Street>(n_streets);
	}
	
	public void visitStreet(Street st){
		visitedStreets.add(st);
	}
	
	/**
	 * Inits car list with correct starting intersection
	 * @param problem
	 * @return
	 */
	public static List<Car> initCarList(Problem problem) {
		List<Car> result = new ArrayList<Car>();
		for(int i=0; i<problem.numberOfCars; i++) {
			result.add(new Car(problem.getStartingIntersection()));
		}
		return result;
	}

	public Intersection getStartingIntersection() {
		return Intersection.map.get(startingIntersection);
	}

}
