package mainround.algorithms.thomas.local;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import mainround.algorithms.Algorithm;
import mainround.entities.Car;
import mainround.entities.Intersection;
import mainround.entities.Problem;
import mainround.entities.Street;

public class AlgorithmRandom2 extends AbstractLocalAlgorithm {
	

	Random rand = new Random();

	@Override
	public Street step(Car c, Set<Street> streets) {
		int streetindex = rand.nextInt(streets.size());
		
		List<Street> alreadyTaken = new ArrayList<Street>();
		List<Street> newStreets = new ArrayList<Street>();
		
		for(Street s : streets) {
			if(s.visited.visited) {
				alreadyTaken.add(s);
			}
			else {
				newStreets.add(s);
			}
		}
		
		Street chosenStreet;
		if(newStreets.size() > 0) {
			chosenStreet = newStreets.get(rand.nextInt(newStreets.size()));
		}
		else {
			chosenStreet = alreadyTaken.get(rand.nextInt(alreadyTaken.size()));
		}
		return chosenStreet;
	}

	

}
