
package mainround.entities;

import java.util.HashSet;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

public class Problem {
	public DefaultDirectedWeightedGraph<Intersection, Street>  graph; 
	public HashSet<Street> visitedStreets;
	public float timeAvailable;
	
	public void setVisitedStreets(int n_streets){
		visitedStreets=new HashSet<Street>(n_streets);
	}
	
	public void visitStreet(Street st){
		visitedStreets.add(st);
	}

}
