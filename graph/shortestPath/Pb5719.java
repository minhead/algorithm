package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int end;
	int value;

	Edge(int end, int value) {
		// TODO Auto-generated constructor stub
		this.end = end;
		this.value = value;
	}
}

//거의 최단경로
public class Pb5719 {
	static int N, M;
	static int S, D, u, v, p;
	static int[] first;
	static boolean[] visited;
	static ArrayList<ArrayList<node>> list ;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());	
			if(N == 0 && M == 0) {
				break;
			}
			st = new StringTokenizer(br.readLine());
			S = stoi(st.nextToken());
			D = stoi(st.nextToken());
			first = new int[N];
			visited = new boolean[N];
			list = new ArrayList<ArrayList<node>>();
			for(int i = 0 ; i< N ; i++) {
				list.add(new ArrayList<node>());
				first[i] = 987654321;
				visited[i] = false;
			}
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				u = stoi(st.nextToken());
				v = stoi(st.nextToken());
				p = stoi(st.nextToken());
				list.get(u).add(new node(v, p));
				//System.out.println(list.get(u).size());
			}

			dijkstra();
			//System.out.print(first[D] + " ");
			deleteLines(D);
			

			for(int i = 0 ; i< N ; i++) {
				list.add(new ArrayList<node>());
				first[i] = 987654321;
				visited[i] = false;
			}
			dijkstra();
	
            
			if(first[D] == 987654321)
				System.out.println(-1);
			else
				System.out.println(first[D]);
		}
		
	}
	
	static void dijkstra() {
		PriorityQueue<node> q = new PriorityQueue<node>();
		q.add(new node(S, 0));
		first[S] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll().index;
			if(visited[now])
				continue;
			visited[now] = true;
			node next;
			int len =  list.get(now).size();

			for(int i = 0 ; i< len; i++) {
				next = list.get(now).get(i);
				if(first[next.index] > first[now] + next.cost) {
					first[next.index] = first[now] + next.cost;
					q.add(new node(next.index, first[next.index] ));
				}
			}
		}
		
	}
	/*
	 * 
	 */
	static void deleteLines(int index) {
		if(index == S)
			return;
		
		/*
		 * index를 가리키는 노드의 엣지 제거
		 */
		for(int i = 0 ; i < N ; i++) {
			int j = 0;
			for(; j < list.get(i).size(); j++) {
				if(list.get(i).get(j).index == index )
					break;
			}
			//System.out.println(j);
			if( (j <  list.get(i).size() ) &&(first[index] == ( first[i] + list.get(i).get(j).cost ))){
				
				list.get(i).get(j).cost = 987654321;
				deleteLines(i);
			}
		}
	}
	
	static class node implements Comparable<node>{
		int index, cost;
		node(int index, int cost){
			this.index = index;
			this.cost = cost;
		}
		@Override
		public int compareTo(node arg0) {
			// TODO Auto-generated method stub
			return this.cost - arg0.cost;
		}
		
	}

}
