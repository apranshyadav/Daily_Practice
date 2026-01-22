package DSA.graph.basics;

import java.util.HashSet;

public class graph_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);
		g.AddEdge(1, 4, 2);
		g.AddEdge(1, 2, 5);
		g.AddEdge(3, 2, 7);
		g.AddEdge(3, 4, -1);
		g.AddEdge(5, 4, 3);
		g.AddEdge(5, 6, 7);
		g.AddEdge(5, 7, 8);
		g.AddEdge(7, 6, 4);
		g.display();
	}

}
