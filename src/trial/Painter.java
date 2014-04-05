package trial;

import java.util.List;

import trial.action.Action;

public class Painter {
	
	public static void paint(List<Action> actions, Image im) {
		for(Action action : actions) {
			action.apply(im.image);
		}
	}
	
	public static String getOutput(List<Action> actions) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(actions.size());
		builder.append("\n");
		
		for(Action action : actions) {
			builder.append(action.toString());
			builder.append("\n");
		}
		
		return builder.toString();
	}
}
