package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//문제
//N의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 그러면 A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.
//입력
//첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
//그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
//출력
//첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
public class Pb1916 {
	static int INF = 1000000000;
	static int[] dist;  //start node부터 i node까지의 누적최단거리
	static boolean[] visited ;// 각 노드별로 방문한 적이 있는지 표시
	static int N,M;
	static ArrayList<Edge> []list;
	
	static class Edge implements Comparable<Edge>{
		int to;
		int value;
		Edge(int to, int value) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.value = value;
		}
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i = 1; i<=N;i++) {
			list[i] = new ArrayList<Edge>();
		}
	
		StringTokenizer st;
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, c));
//			list[b].add(new Edge(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 1; i<=N;i++) {
			dist[i]=INF;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<Pb1916.Edge>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}
		});
		dist[start]=0;
		
		pq.add(new Edge(start, dist[start]));
		
		while(!pq.isEmpty()) {
			int distance = pq.peek().value;
			int here = pq.peek().to;
//			System.out.println(distance);
			pq.poll();
			visited[here] = true;
			
			if(distance > dist[here])
				continue;
			for(int i = 0; i<list[here].size();i++) {
				int there = list[here].get(i).to;
				int d = list[here].get(i).value;
				if(visited[there]==false&&dist[there]>dist[here]+d) {
					dist[there] = dist[here]+d;
					pq.offer(new Edge(there, dist[there]));
				}
			}
		}
		
		System.out.println(dist[end]);
		
		

	}

}
