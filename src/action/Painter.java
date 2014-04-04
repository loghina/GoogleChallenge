package action;

import java.util.List;

public class Painter {

	
	public static void paint(List<Action> actions, boolean[][] image) {
		
		for(Action action : actions) {
			action.apply(image);
		}
	}
}
