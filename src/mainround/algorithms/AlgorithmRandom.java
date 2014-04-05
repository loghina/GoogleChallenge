package mainround.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public class AlgorithmRandom implements Algorithm {

	@Override
	public List<Car> calculate(Problem problem) {
		List<Car> result = Problem.initCarList(problem);
		float time = problem.timeAvailable;
		
		Random rand = new Random();
		
		for(Car c : result) {
			
			Intersection act = c.getActualIntersection();

			while(c.time_passed < time) {
				Set<Street> edges = problem.graph.outgoingEdgesOf(act);
				int streetindex = rand.nextInt(edges.size());
				Street chosenStreet = (Street)edges.toArray()[streetindex];
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

}
