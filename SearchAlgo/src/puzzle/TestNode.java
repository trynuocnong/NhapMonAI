package puzzle;

public class TestNode {

	private static void printNode(Puzzle p, Node n) {
		if (n == null) {
			System.out.println("null\n");
		} else {
			System.out.println("H1: " + p.computeH1(n));
			n.setH(p.computeH2(n));
			System.out.println("H2: " + n.getH());
			System.out.println(n);
		}
	}

	private static Node runAlgo(Puzzle p, IPuzzleAlgo ipa) {
		Node n;
		long startTime, endTime;
		startTime = System.nanoTime();
		n = ipa.execute(p);
		endTime = System.nanoTime();
		System.out.println("Run Time: " + (endTime - startTime) + " (nanosecond)");
		if (n != null)
			System.out.println("Path Cost: " + n.getG());
		return n;
	}

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\IT2\\Nhap Mon AI\\Lab\\Lab 5_8Puzzle\\txt\\PuzzleMap.txt",
				"D:\\IT2\\Nhap Mon AI\\Lab\\Lab 5_8Puzzle\\txt\\PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node goalState = p.getGoalState();
		System.out.println("Initial State:");
		printNode(p, initialState);

		System.out.println("Goal State:");
		printNode(p, goalState);

		System.out.println("------------------\n*MOVE WHITE TILE*\n");
		Node move, moveNext;

		// White Tile move RIGHT
		move = p.moveWhiteTile(initialState, 'r');
		System.out.println("White Tile move RIGHT:");
		printNode(p, move);

		moveNext = p.moveWhiteTile(move, 'r');
		System.out.println("White Tile move RIGHT(already at egde):");
		printNode(p, moveNext);

		// White Tile move LEFT
		move = p.moveWhiteTile(initialState, 'l');
		System.out.println("White Tile move LEFT:");
		printNode(p, move);

		moveNext = p.moveWhiteTile(move, 'l');
		System.out.println("White Tile move LEFT(already at egde):");
		printNode(p, moveNext);

		// White Tile move UP
		move = p.moveWhiteTile(initialState, 'u');
		System.out.println("White Tile move UP:");
		printNode(p, move);

		moveNext = p.moveWhiteTile(move, 'u');
		System.out.println("White Tile move UP(already at egde):");
		printNode(p, moveNext);

		// White Tile move DOWN
		move = p.moveWhiteTile(initialState, 'd');
		System.out.println("White Tile move DOWN:");
		printNode(p, move);

		moveNext = p.moveWhiteTile(move, 'd');
		System.out.println("White Tile move DOWN(already at egde):");
		printNode(p, moveNext);

		System.out.println("------------------\n*ALGORITHMS*\n");

		System.out.println("Greedy Best First Search Algo (with h2):");
		IPuzzleAlgo GBFS = new GreedyBestFirstSearchAlgo();
		System.out.println(runAlgo(p, GBFS));

		System.out.println("A Star Search Algo (with h2):");
		IPuzzleAlgo aStar = new AStarSearchAlgo();
		System.out.println(runAlgo(p, aStar));

		System.out.println("Depth First Search Algo (with h2):");
		IPuzzleAlgo DFS = new DepthFirstSearchAlgo();
		System.out.println(runAlgo(p, DFS));

		System.out.println("Breadth First Search Algo (with h2):");
		IPuzzleAlgo BFS = new BreadthFirstSearchAlgo();
		System.out.println(runAlgo(p, BFS));
	}
}