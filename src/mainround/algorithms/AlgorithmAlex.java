package mainround.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;

import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public class AlgorithmAlex {
	public AlgorithmAlex(){}
	
	public List<Car> calculate(Problem input){
		DefaultDirectedWeightedGraph<Intersection, Street>  myGraph=input.graph; 
		HashSet<Street> visStreets=input.visitedStreets;
			
		ArrayList<Car> result=(ArrayList<Car>)Problem.initCarList(input);
		for (int i=0;i<input.numberOfCars;i++){
			result.add(i, FindAPath(input));
		}
		
		return result;
	}
	
	public Car FindAPath(Problem input){
		
		Intersection start=Intersection.map.get(input.startingIntersection);
		Set<Street> nextStreets=input.graph.outgoingEdgesOf(start);
		for (Street st:nextStreets){
			
		}
		
		
		return null;
	}
}
