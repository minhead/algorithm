package dijkstra;

import java.util.ArrayList;

public class Dijkstra {

	static final int M_size = 100; //max number of vertices
	static final int INTMAX = 2087654321; //infinite
	
	static ArrayList<int[]> AdjList[] = new ArrayList[M_size];
	static int visited[] = new int[M_size];
	
	static void dijkstra(int start) {
		dijkstra(start, -1);
	}
	static void dijkstra(int start, int dest) {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
