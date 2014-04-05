package mainround.algorithms.thomas.global;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import mainround.algorithms.Algorithm;
import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public class LongLatAlgorithm extends AbstractGlobalAlgorithm implements Algorithm {

	@Override
	public Street chooseStreet(Car car, Intersection inter, Set<Street> edges, List<Car> cars, Problem problem) {
		Street chosenStreet = null;
		Street chosenUnvisitedStreet = null;
		
		double maxdist = 0;
		double maxdistunvisited = 0;
		for(Street s : edges) {
			if(!car.testStreet(s, problem.timeAvailable)) {
				continue;
			}
			double mindist = Double.POSITIVE_INFINITY;
			
			for(Car c : cars) {
				if(c == car) continue;
				double actdist = s.B.distanceTo(c.getActualIntersection());
				if(actdist < mindist) mindist = actdist;
			}
			
			if(mindist > maxdist) {
				chosenStreet = s;
				maxdist = mindist;
			}
			if(!s.visited.visited && mindist > maxdistunvisited) {
				chosenUnvisitedStreet = s;
				maxdistunvisited = mindist;
			}
		}
		
		if(chosenUnvisitedStreet != null) {
			return chosenUnvisitedStreet;
		}
		else if(chosenStreet != null) {
			return chosenStreet;
		}
		return null;
	}
	

	

}
