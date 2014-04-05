package mainround;

import java.util.List;

import mainround.entities.Car;
import mainround.entities.Intersection;

public class Output {
	
	// TODO: params
	public static String getOutput(List<Car> input) {
		StringBuilder builder = new StringBuilder();
		// TODO: output
		builder.append(input.size() +"\n");
		for (Car i:input){
			builder.append(i.intersections.size()+"\n");
			for (Intersection j : i.intersections){
				builder.append(j.getIndex()+"\n");
			}
		}
		return builder.toString();
	}
	
}
