package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pb2606 {

	static int N,M;
	static ArrayList<Integer>[] list;
	static int visited[];
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[N+1];
		visited = new int[N+1];
		for(int i = 1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(1);
		count=0;
		bfs(1,que);
		System.out.println(count);

		
	}
	static void bfs(int here, Queue<Integer> que) {
		
		while(!que.isEmpty()) {
			int there = que.poll();
			visited[there]=1;
			for(int i = 0;i<list[there].size();i++) {
				if(visited[list[there].get(i)]==0) {
					que.offer(list[there].get(i));
					visited[list[there].get(i)]=1;
					count++;
				}
			}
		}
		
	}

}
