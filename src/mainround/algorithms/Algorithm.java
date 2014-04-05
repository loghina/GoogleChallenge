package mainround.algorithms;

import java.util.List;

import mainround.entities.Car;
import mainround.entities.Problem;

public interface Algorithm {

	// TODO: change return type and parameter
	public List<Car> calculate(Problem problem);
}
