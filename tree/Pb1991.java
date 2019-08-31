package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pb1991 {//트리순회

	static class Edge {
		char p;
		char l;
		char r;

		public Edge(char p, char l, char r) {
			// TODO Auto-generated constructor stub
			this.p = p;
			this.l = l;
			this.r = r;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] list = (ArrayList<Edge>[])new ArrayList[N+1];
		for(int i =1; i<=N;i++) {
			list[i]= new ArrayList<>();
		}
		for(int i = 1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			list[i].add(new Edge(a,b,c));
		}
		int start = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
	}

}
