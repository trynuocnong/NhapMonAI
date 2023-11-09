package AStar_Greedy;

public class TestDrive {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);

		s.addEdge(a, 2);
		s.addEdge(b, 3);
		a.addEdge(c, 3);
		b.addEdge(c, 1);
		b.addEdge(d, 3);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);

		// Greedy Best First Search Test
		System.out.println("*Greedy Best First Search Test:");
		System.out.println("Greedy Best First Search 1 Test:");
		IInformedSearchAlgo GdBFS = new GreedyBestFirstSearchAlgo();
		Node resGD1 = GdBFS.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(resGD1));

		System.out.println("Greedy Best First Search 2 Test:");
		Node resGD2 = GdBFS.execute(s, a.getLabel(), g.getLabel());
		System.out.println(NodeUtils.printPath(resGD2));

		System.out.println("----------------------------");

		// A Star Search Test
		System.out.println("*A Star First Search Test:");
		System.out.println("A Star First Search 1 Test:");
		IInformedSearchAlgo aStar = new AStarSearchAlgo();
		Node resAS1 = aStar.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(resAS1));

		System.out.println("A Star First Search 2 Test:");
		Node resAS2 = aStar.execute(s, a.getLabel(), g.getLabel());
		System.out.println(NodeUtils.printPath(resAS2));

		System.out.println("----------------------------");

		// A Star Search Test
		System.out.println("*isAdmissibleH() Test:");
		boolean resASh = ((AStarSearchAlgo) aStar).isAdmissibleH(s, g.getLabel());
		System.out.println(resASh);
	}
}
