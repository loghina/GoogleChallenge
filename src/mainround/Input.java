package mainround;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;


public class Input {

	// TODO: output type
	public static Problem read(String filename) {
		Problem result = null;
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return result;
		}
		
		try {
			result = new Problem();
			result.graph = new DefaultDirectedWeightedGraph<Intersection, Street>(new EdgeFactory<Intersection, Street>() {
				@Override
				public Street createEdge(Intersection arg0, Intersection arg1) {
					Street s = new Street();
					s.A = arg0;
					s.B = arg1;
					return s;
				}
			});
			String size = reader.readLine();
			if(size == null) {
				System.out.println("not enough input, size missing");
				reader.close();
				return result;
			}
			
			String parts[] = size.split(" ");
			int numberJunctions = Integer.parseInt(parts[0]);
			int numberStreets = Integer.parseInt(parts[1]);
			int timeAvailable = Integer.parseInt(parts[2]);
			int numberCars = Integer.parseInt(parts[3]);
			int startingIntersection = Integer.parseInt(parts[4]);
			
			result.timeAvailable = timeAvailable;
			result.numberOfCars = numberCars;
			result.startingIntersection = startingIntersection;
			
			// Junctions
			for(int i=0; i<numberJunctions; i++) {
				reader.readLine(); // Ignore coordinates
				Intersection intersection = new Intersection();
				intersection.index = i;
				Intersection.map.put(i, intersection);
				// TODO: lat/long if necessary
				result.graph.addVertex(intersection);
			}
			
			// Streets
			for(int i=0; i<numberStreets; i++) {
				String street = reader.readLine();
				parts = street.split(" ");
				
				int a = Integer.parseInt(parts[0]);
				int b = Integer.parseInt(parts[1]);
				int direction = Integer.parseInt(parts[2]);
				int cost = Integer.parseInt(parts[3]);
				int length = Integer.parseInt(parts[4]);
				
				Street s = result.graph.addEdge(Intersection.map.get(a), Intersection.map.get(b));
				s.cost = cost;
				s.length = length;
				
				if(direction == 2) {
					Street soposite = result.graph.addEdge(Intersection.map.get(b), Intersection.map.get(a));
					soposite.cost = cost;
					soposite.length = length;
					soposite.visited = s.visited;
				}
			}
			
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
	}
}
