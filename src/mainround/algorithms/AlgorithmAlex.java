package mainround.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
			
		List<Car> result=new ArrayList<Car>();
			
		return result;
	}
}
