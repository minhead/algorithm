package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//����
//N�� ���ð� �ִ�. �׸��� �� ���ÿ��� ����Ͽ� �ٸ� ���ÿ� �����ϴ� M���� ������ �ִ�. �츮�� A��° ���ÿ��� B��° ���ñ��� ���µ� ��� ���� ����� �ּ�ȭ ��Ű���� �Ѵ�. �׷��� A��° ���ÿ��� B��° ���ñ��� ���µ� ��� �ּҺ���� ����Ͽ���. ������ ��ȣ�� 1���� N�����̴�.
//�Է�
//ù° �ٿ� ������ ���� N(1 �� N �� 1,000)�� �־����� ��° �ٿ��� ������ ���� M(1 �� M �� 100,000)�� �־�����. �׸��� ��° �ٺ��� M+2�ٱ��� ������ ���� ������ ������ �־�����. ���� ó������ �� ������ ��� ������ ��ȣ�� �־�����. �׸��� �� �������� �������� ���� ��ȣ�� �־����� �� �� ���� ����� �־�����. ���� ����� 0���� ũ�ų� ����, 100,000���� ���� �����̴�.
//�׸��� M+3° �ٿ��� �츮�� ���ϰ��� �ϴ� ���� ������� ���ù�ȣ�� �������� ���ù�ȣ�� �־�����. ��������� �������� �� �� �ִ� ��츸 �Է����� �־�����.
//���
//ù° �ٿ� ��� ���ÿ��� ���� ���ñ��� ���µ� ��� �ּ� ����� ����Ѵ�.
public class Pb1916 {
	static int INF = 1000000000;
	static int[] dist;  //start node���� i node������ �����ִܰŸ�
	static boolean[] visited ;// �� ��庰�� �湮�� ���� �ִ��� ǥ��
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
