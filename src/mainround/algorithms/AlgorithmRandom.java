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
			double usedTime = 0;
			while(usedTime < time) {

				Set<Street> edges = problem.graph.edgesOf(act);
				int streetindex = rand.nextInt(edges.size());
				Street chosenStreet = (Street)edges.toArray()[streetindex];
				// TODO: optimize, only streets which low enough cost
				if(usedTime + chosenStreet.cost > time) {
					break;
				}
				act = chosenStreet.B;
			}
			
		}
		
		return null;
	}

}
