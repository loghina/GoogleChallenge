package mainround.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.alg.NeighborIndex;
import org.jgrapht.traverse.DepthFirstIterator;

import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public class AlgoCH implements Algorithm{

	@Override
	public List<Car> calculate(Problem problem) {

		Car cars[] = new Car[problem.numberOfCars];
		for(int i=0;i<problem.numberOfCars;i++)
		{
			cars[i] = new Car(problem.getStartingIntersection());
			
		}
//		NeighborIndex<Intersection, Street> ni = new NeighborIndex<Intersection, Street>(problem.graph);
//		for(int i =0;i<problem.numberOfCars;i++)
//		{
		Intersection tmp;
		Stack<Intersection> stk = new Stack<Intersection>();
		stk.push(problem.getStartingIntersection());
		while(!stk.isEmpty())
		{
		tmp = stk.pop();	
		Street str[] = problem.graph.outgoingEdgesOf(tmp).toArray(new Street[0]);
		for(Street street : str)
		{
			stk.push(street.B);
		}
		
		
		
		for(int i =0;i<problem.numberOfCars;i++)
		{
			boolean tookstreet = false;
			for(Street street : str)
			{
				if(cars[i].getActualIntersection().index==tmp.index)
				{
					if(!street.visited.visited)
						{
							if(cars[i].testStreet(street,problem.timeAvailable))
								{
									cars[i].useStreet(street);
									
									tookstreet = true;
									street.visited.visited=true;
									break;
								}
//							street.visited.visited=true;
						}
				}
			}
				if(!tookstreet && cars[i].getActualIntersection().index==tmp.index)
				{
					for(Street street : str)
					{
						if(cars[i].testStreet(street, problem.timeAvailable))
						{
							cars[i].useStreet(street);
							break;
						}
				
					}
				}
			
		}
		
		
		
			
		}
//		}
		
		
		return Arrays.asList(cars);
	}
	
	
		
	
	
	
	

}
