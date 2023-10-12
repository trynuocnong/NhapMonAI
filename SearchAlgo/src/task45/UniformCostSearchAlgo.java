package task45;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		/*
		 * Create the queue that put nodes in order of their path cost
		 */
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			//Compare 2 nodes by their path cost
			public int compare(Node o1, Node o2) {
				return (int) (o1.getPathCost()-o2.getPathCost());
			}
			
		});
		//If root node is goal state then return root node
		if (root.getLabel().equals(goal)) return root;
		List<Node> explored = new ArrayList<>();
		frontier.add(root); //add root node to frontier
		while (!frontier.isEmpty()) { //having root node added
			//pull it out to check if it is goal state
			Node currentNode = frontier.poll();
			//if yes then return it
			if(currentNode.getLabel().equals(goal)) return currentNode;
			explored.add(currentNode); //add it to visited list
			
			/*
			 * check if its children nodes are already visited
			 * if not, update its children's path cost equals current path cost plus the
			 * weight to its children and add its children into the frontier
			 * if yes, caculate the new path cost and compare it to the least path cost
			 * in the frontier. If it's greater than the least path cost in frontier then
			 * set it as the current node and add its children into the frontier 
			 */
			List<Node> children = currentNode.getChildrenNodes();
			for (Node child : children) {

				//current node's child isn't consisted of either the visited list 
				//or the frontier 
				if (!frontier.contains(child) && !explored.contains(child)) {
					for (Edge edge : currentNode.getChildren()) {
						if (edge.getEnd().equals(child)) {
							//update its children's path cost
							child.setPathCost(edge.getWeight()+currentNode.getPathCost());
							break;
						}
					}
					//add its children into frontier
					child.setParent(currentNode);
					frontier.add(child);
				}else {
					//current node's child is already visited before
					double newChildPathCost = 0;
					//caculate the new path cost
					for (Edge edge : currentNode.getChildren()) {
						if (edge.getEnd().equals(child)) {
							newChildPathCost = edge.getWeight() + currentNode.getPathCost();
						}
					}
					for (Node frnode : frontier) {
						if (frnode.equals(child)) {
							//compare it to the least path cost path in frontier
							if (frnode.getPathCost() > newChildPathCost) {
								//remove the last path
								frontier.remove(frnode);
								//set it as new path cost
								child.setPathCost(newChildPathCost);
								//add it children into frontier
								child.setParent(currentNode);
								frontier.add(child);
								break;
							}
						}
					}
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
		startNode.setPathCost(0);
		return execute(startNode, goal);
	}

}
