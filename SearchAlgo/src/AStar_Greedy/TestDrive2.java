package AStar_Greedy;

public class TestDrive2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node s = new Node("S", 30);
		Node a = new Node("A", 22);
		Node b = new Node("B", 25);
		Node c = new Node("C",20);
		Node d = new Node("D", 10);
		Node e = new Node("E", 6);
		Node f = new Node("F", 8);
		Node g1 = new Node("G1", 0);
		Node g2 = new Node("G2", 0);
		Node h = new Node("H", 16);
		Node k = new Node("K", 26);
		
		s.addEdge(b, 8);
		s.addEdge(c, 19);
		s.addEdge(k, 6);
		a.addEdge(b, 8);
		a.addEdge(d, 15);
		b.addEdge(a, 7);
		b.addEdge(c, 11);
		c.addEdge(e, 12);
		d.addEdge(g2, 9);
		e.addEdge(g1, 7);
		f.addEdge(g1, 10);		
		h.addEdge(f, 7);
		h.addEdge(g1, 19);
		h.addEdge(s, 9);
		k.addEdge(a, 13);
		k.addEdge(h, 10);
		
		// Greedy Best First Search Test
		System.out.println("*Greedy Best First Search Test:");
		System.out.println("Greedy Best First Search 1 Test:");
		IInformedSearchAlgo GdBFS = new GreedyBestFirstSearchAlgo();
		Node resGD1 = GdBFS.execute(s, g1.getLabel());
		System.out.println(NodeUtils.printPath(resGD1));

		System.out.println("Greedy Best First Search 2 Test:");
		Node resGD2 = GdBFS.execute(s, g2.getLabel());
		System.out.println(NodeUtils.printPath(resGD2));

		System.out.println("----------------------------");

		// A Star Search Test
		System.out.println("*A Star First Search Test:");
		System.out.println("A Star First Search 1 Test:");
		IInformedSearchAlgo aStar = new AStarSearchAlgo();
		Node resAS1 = aStar.execute(s, g1.getLabel());
		System.out.println(NodeUtils.printPath(resAS1));

		System.out.println("A Star First Search 2 Test:");
		Node resAS2 = aStar.execute(s, g2.getLabel());
		System.out.println(NodeUtils.printPath(resAS2));
	}
}
