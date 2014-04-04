package action;

import java.util.List;

public class Painter {
	
	public static void paint(List<Action> actions, boolean[][] image) {
		for(Action action : actions) {
			action.apply(image);
		}
	}
	
	public static String getOutputErase(List<EraseCell> actions) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(actions.size());
		builder.append("\n");
		
		for(Action action : actions) {
			builder.append(action.toString());
			builder.append("\n");
		}
		
		return builder.toString();
	}
	public static String getOutputPaint(List<PaintSQ> actions) {
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
