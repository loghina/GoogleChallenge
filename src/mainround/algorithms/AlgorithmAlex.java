package mainround.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;

import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public class AlgorithmAlex {
	public AlgorithmAlex(){}
	
	public List<Car> calculate(Problem input){
		ArrayList<Car> result=(ArrayList<Car>)Problem.initCarList(input);		
		
		//-----------------
		float time = input.timeAvailable;
		
		Random rand = new Random();
		
		for(Car c : result) {
			
			Intersection act = c.getActualIntersection();

			while(c.time_passed < time) {
				Set<Street> edges = input.graph.outgoingEdgesOf(act);
				Street chosenStreet=FindNextStreet(edges);
				if (chosenStreet==null){
					//if all streets already taken - random choice
					int streetindex = rand.nextInt(edges.size());
					chosenStreet = (Street)edges.toArray()[streetindex];
				}
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
	
	public Street FindNextStreet(Set<Street> futureStreets){
		Street nextStreet=null;
		//choose the future street with max length
		for (Street s:futureStreets){
			if (s.visited.visited==false){
				if (nextStreet==null)
					nextStreet=s;
				else{
					if (s.length>nextStreet.length){
						nextStreet=s;
					}
				}
			}
		}		
		return nextStreet;
	}
	
}
