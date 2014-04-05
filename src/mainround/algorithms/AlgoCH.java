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
		
		boolean[] visited = new boolean[problem.numberOfStreets];
		for(int v = 0;v<problem.numberOfStreets;v++)
		{
		   visited[v]=false;	
		}
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
			if(!visited[street.index])
			{
				stk.push(street.B);
				visited[street.index]=true;
			}
		}
		
		
		for(int i =0;i<problem.numberOfCars;i++)
		{
			Street best = new Street();
			best.length =-1;
			for(Street street : str)
			{
			    if(!street.visited.visited && best.length<street.length)
			    	best=street;
			}
			boolean tookstreet = false;
			
				if(cars[i].getActualIntersection().index==tmp.index)
				{
					
							if(best.length!=-1 && cars[i].testStreet(best,problem.timeAvailable))
								{
									cars[i].useStreet(best);
									
									tookstreet = true;
									best.visited.visited=true;
									break;
								}
//							street.visited.visited=true;
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
