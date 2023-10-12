package task3;

public class TestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); 
		Node nodeB = new Node("B");
		Node nodeC = new Node("C"); 
		Node nodeD = new Node("D");
		Node nodeE = new Node("E"); 
		Node nodeF = new Node("F");
		Node nodeG = new Node("G"); 
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); 
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); 
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); 
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); 
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); 
		nodeF.addEdge(nodeG, 1);
		

		//BFS Test
		System.out.println("BFS Test:");
		System.out.println("BFS Task 1 Test:");
		ISearchAlgo algoBFS1 = new BreadthFirstSearchAlgo();
		Node resultBFS1 = algoBFS1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(resultBFS1));
		
		System.out.println("BFS Task 2 Test:");
		ISearchAlgo algoBFS2 = new BreadthFirstSearchAlgo();
		Node resultBFS2 = algoBFS2.execute(nodeS, "A", "G");
		System.out.println(NodeUtils.printPath(resultBFS2));
		
		//DFS Test
		System.out.println("\nDFS Test:");
		System.out.println("DFS Task 1 Test:");
		ISearchAlgo algoDFS1 = new DepthFirstSearchAlgo();
		Node resultDFS1 = algoDFS1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(resultDFS1));
		
		System.out.println("DFS Task 2 Test:");
		ISearchAlgo algoDFS2 = new DepthFirstSearchAlgo();
		Node resultDFS2 = algoDFS2.execute(nodeS, "B", "G");
		System.out.println(NodeUtils.printPath(resultDFS2));
	}

}
