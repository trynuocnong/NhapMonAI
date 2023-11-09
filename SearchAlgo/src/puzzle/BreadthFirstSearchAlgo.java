package puzzle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements IPuzzleAlgo {

	@Override
	// with h2
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new LinkedList<>();
		model.getInitialState().setH(model.computeH2(model.getInitialState()));
		frontier.add(model.getInitialState());
		Node goal = model.getGoalState();
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.equals(goal))
				return currentNode;
			long endTime = System.nanoTime();
			if (endTime - startTime > 5000000000l) {
				System.out.println("Time out! Unable to solve");
				return null;
			}
			explored.add(currentNode);

			List<Node> children = model.getSuccessors(currentNode);
			for (Node n : children) {
				if (!frontier.contains(n) && !explored.contains(n)) {
					n.setG(currentNode.getG() + 1);
					frontier.add(n);
				}
			}
		}
		return null;
	}

}
