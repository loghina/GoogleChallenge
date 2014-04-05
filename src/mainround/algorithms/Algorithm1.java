package mainround.algorithms;

import java.util.List;

import org.jgraph.graph.Edge;
import org.jgrapht.alg.KShortestPaths;
import org.jgrapht.traverse.BreadthFirstIterator;
import mainround.entities.Car;
import mainround.entities.Problem;
import mainround.entities.Intersection;
import mainround.entities.Street;

public class Algorithm1 implements Algorithm {

	@Override
	public List<Car> calculate(Problem problem) {
		// TODO Auto-generated method stub
		BreadthFirstIterator<Intersection, Street> bfs=new BreadthFirstIterator<Intersection, Street>(problem.graph,problem.getStartingIntersection());
		while(bfs.hasNext()){
			
		}
		//KShortestPaths Kshort=new KShortestPaths(problem.graph, problem.startingIntersection, problem.graph.);
		
		return null;
	}

}
