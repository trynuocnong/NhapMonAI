package task12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{
	@Override
	public Node execute(Node root, String goal) {

		//The upper part is the same of BFS Algo
		if (root.getLabel().equals(goal)) return root;
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			if(currentNode.getLabel().equals(goal)) return currentNode;
			explored.add(currentNode);
			
			List<Node> children = currentNode.getChildrenNodes();
			/*
			 * check if its children nodes are already visited
			 * if not, add them into frontier and set the current node as their parent
			 */
			for (int i = children.size()-1; i >= 0; i--) {
				if (!frontier.contains(children.get(i)) && !explored.contains(children.get(i))) {
					frontier.push(children.get(i));
					children.get(i).setParent(currentNode);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {

		if (root.getLabel().equals(goal)) return root;
		if (start.equals(goal)) return new Node(goal);
		Node startNode = execute(root, start);
		startNode.setParent(null);
		return execute(startNode, goal);
	}

}
