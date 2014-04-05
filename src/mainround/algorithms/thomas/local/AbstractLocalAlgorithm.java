package mainround.algorithms.thomas.local;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import mainround.algorithms.Algorithm;
import mainround.algorithms.thomas.AbstractAlgorithm;
import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public abstract class AbstractLocalAlgorithm extends AbstractAlgorithm {
	@Override
	public List<Car> calculate(Problem problem) {
		List<Car> result = Problem.initCarList(problem);
		float time = problem.timeAvailable;
		
		
		for(Car c : result) {
			
			Intersection act = c.getActualIntersection();

			while(c.time_passed < time) {
				Set<Street> edges = problem.graph.outgoingEdgesOf(act);
				
				Street chosenStreet = step(c, edges);
				
				if(chosenStreet == null) break;
				// TODO: optimize, only streets which low enough cost
				if(c.time_passed + chosenStreet.cost > time) {
					break;
				}
				act = chosenStreet.B;
				c.useStreet(chosenStreet);
			}
		}
		
		return result;
	}
	
	public abstract Street step(Car c, Set<Street> streets);
}
