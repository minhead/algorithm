package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//트리의 지름

//5
//1 3 2 -1
//2 4 4 -1
//3 1 2 4 3 -1
//4 2 4 3 3 5 6 -1
//5 4 6 -1

//11

public class Pb1167 {

	static class Edge {
		int to;
		int value;

		Edge(int to, int value) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.value = value;
		}
	}
	
	static int[] bfs(ArrayList<Edge>[] list, int start, int n) {
		boolean[] visited= new boolean[n+1];
		int[] dist = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int i = 0;i<list[a].size();i++) {
				int b = list[a].get(i).to;
				int c = list[a].get(i).value;
				if(!visited[b]) {
					visited[b]=true;
					q.add(b);
					dist[b]= dist[a]+c;
				}
			}
		}
		return dist;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int dist[] = new int[V+1];
		ArrayList<Edge> list[];
		list = (ArrayList<Edge>[])new ArrayList[V+1];
		for(int i = 1 ; i<=V;i++)
			list[i] = new ArrayList<Edge>();
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1) {
					break;
				}	
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Edge(b, c));
				list[b].add(new Edge(a, c));
			}
		}
		dist = bfs(list,1,V);
		
		int start = 1;
		for(int i = 2; i<=V; i++) {
			if(dist[start]<dist[i])
				start = i;
		}
		
		dist = bfs(list,start,V);
		Arrays.sort(dist);
		System.out.println(dist[V]);

	}

}
