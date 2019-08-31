package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//트리의 부모 찾기
//루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//입력
//첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//출력
//첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
public class Pb11725 {

	static class Edge {
		int from;
		int to;
		public Edge(int from, int to) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
		}
	}
	static int N;
	static ArrayList<Integer>[] list;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		StringTokenizer st;
		int a;
		int b;
		for(int i = 1; i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();

		int start;
		q.offer(1);
		int[] par = new int[N+1];
		while(!q.isEmpty()) {			
			start = q.poll();
			if(!visited[start]) {
				visited[start]=true;
				for(int i=0;i<list[start].size();i++) {
					int x = list[start].get(i);
					if(!visited[x]) {
					q.offer(x);
					par[x] = start;
					}
				}
			}
		}
		for(int i = 2; i<=N;i++)
		System.out.println(par[i]);
		
		
		
		
	}

}
