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
	
	public List<Car> calculate(Problem input) throws InterruptedException{
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
					/*int streetindex = rand.nextInt(edges.size());
					chosenStreet = (Street)edges.toArray()[streetindex];
					*/
					//if all streets already taken - minimum time cost
					/*Street min_st=null;
					for (Street st:edges){
						if (min_st==null)
							min_st=st;
						else{
							if (st.cost<min_st.cost)
								min_st=st;
						}
					}
					chosenStreet=min_st;
					if (chosenStreet==null)		*/
					
					//if all streets already taken - check if next is taken
					boolean flagbreak=false;
					Set<Street> next_nonvisited_edges=new HashSet<Street>();
					Intersection prec_inters=null;
					for (Street st:edges){
						Set<Street> next_edges = input.graph.outgoingEdgesOf(st.B);
						
						for(Street nextLevel:next_edges){
							if (!nextLevel.visited.visited && (c.time_passed + st.cost+nextLevel.cost <= time)){
								chosenStreet=st;
								flagbreak=true;
								break;
								//next_nonvisited_edges.add(nextLevel);
								//prec_inters=st.A;
							}
						}
						if (flagbreak)	break;
					}
					/*Street possibleStreet=FindNextStreet(next_nonvisited_edges);
					if (possibleStreet!=null)
						chosenStreet=input.graph.getEdge(prec_inters, possibleStreet.A);
					if (chosenStreet!=null && possibleStreet!=null){
						c.useStreet(chosenStreet);
						c.useStreet(possibleStreet);*/
					if (chosenStreet==null){
						int streetindex = rand.nextInt(edges.size());
						chosenStreet = (Street)edges.toArray()[streetindex];
					}
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
	
	public int RecursiveFindLengthNextIntersection(Problem input,Intersection actualInters, Car c){
		Set<Street> futureStreets = input.graph.outgoingEdgesOf(actualInters);
		int cur_length,best=0;
		Street bestStreet=null;
		boolean foundSuccessor=false;
		
		//choose the street with max length
		for (Street s:futureStreets){
			if (s.visited.visited==false){
				foundSuccessor=true;
				cur_length=RecursiveFindLengthNextIntersection(input,s.B,c)+s.length;
				if (cur_length>best){
					best=cur_length;
					bestStreet=s;
				}
			}
		}
		if (!foundSuccessor)
			best=0;
		else
			c.useStreet(bestStreet);
		return best;
	}
}
