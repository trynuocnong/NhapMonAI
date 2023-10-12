package task3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo{
	@Override
	public Node execute(Node root, String goal) {
				
		//If root node is goal node then return root node
		if (root.getLabel().equals(goal)) return root;
		
		Queue<Node> queue = new LinkedList<Node>(); //unvisited nodes list
		
		queue.add(root); //add root node to frontier

		while (!queue.isEmpty()) { //having root node in frontier
			/*
			 * take the latest node in frontier out to check if it is goal node
			 * if yes, then return the current node
			 */
			Node currentNode = queue.poll();
			if(currentNode.getLabel().equals(goal)) return currentNode;
			
			/*
			 * add its children nodes into queue and set the current node as their parent
			 */
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {
				queue.add(child);
				child.setParent(currentNode);
			}
		}
		return null; //haven't find any goal
	}

	@Override
	public Node execute(Node root, String start, String goal) {

		//If root node is goal node then return root node
		if (root.getLabel().equals(goal)) return root;
		//If start node is goal node then use above method and set goal node as start node
		if (start.equals(goal)) return new Node(goal);
		
		//start node is the ending vertex of 'root node to start node' edge
		Node startNode = execute(root, start);
		//then simply use above method and set root node as start node
		startNode.setParent(null); //remove root node as parent
		return execute(startNode, goal);
	}

}
