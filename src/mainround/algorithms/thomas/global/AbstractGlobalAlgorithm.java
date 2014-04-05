package mainround.algorithms.thomas.global;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import mainround.algorithms.thomas.AbstractAlgorithm;
import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public abstract class AbstractGlobalAlgorithm extends AbstractAlgorithm {
	public class FastestCar implements Comparable<FastestCar> {
		Car c;

		public FastestCar(Car c) {
			this.c = c;
		}

		@Override
		public int compareTo(FastestCar arg0) {
			return arg0.c.time_passed - c.time_passed;
		}
	}

	@Override
	public List<Car> calculate(Problem problem) {
		List<Car> result = Problem.initCarList(problem);
		PriorityQueue<FastestCar> queue = new PriorityQueue<FastestCar>();
		
		for(Car c : result) {
			queue.add(new FastestCar(c));
		}
		
		while(!queue.isEmpty()) {
			FastestCar fc = queue.poll();
			Intersection actInter = fc.c.getActualIntersection();
			Set<Street> edges = problem.graph.outgoingEdgesOf(actInter);
			
			Street s = chooseStreet(fc.c, actInter, edges, result, problem);
			
			if(s == null) continue;
			if(fc.c.testStreet(s, problem.timeAvailable)) {
				fc.c.useStreet(s);
				queue.add(fc);
			}
		}
		
		
		return result;
	}
	
	/**
	 * 
	 * @param car
	 * @param inter
	 * @param edges
	 * @param cars
	 * @param problems
	 * @return
	 */
	public abstract Street chooseStreet(Car actcar, Intersection inter, Set<Street> edges, List<Car> cars, Problem problem);
}
