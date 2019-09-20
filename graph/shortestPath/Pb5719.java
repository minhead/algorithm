package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//요즘 많은 자동차에서는 GPS 네비게이션 장비가 설치되어 있다. 
//네비게이션은 사용자가 입력한 출발점과 도착점 사이의 최단 경로를 검색해 준다.
//하지만, 교통 상황을 고려하지 않고 최단 경로를 검색하는 경우에는 극심한 교통 정체를 경험할 수 있다.
//상근이는 오직 자기 자신만 사용 가능한 네비게이션을 만들고 있다. 
//이 네비게이션은 절대로 최단 경로를 찾아주지 않는다. 항상 거의 최단 경로를 찾아준다.
//거의 최단 경로란 최단 경로에 포함되지 않는 도로로만 이루어진 경로 중 가장 짧은 것을 말한다. 
//예를 들어, 도로 지도가 아래와 같을 때를 생각해보자. 원은 장소를 의미하고, 
//선은 단방향 도로를 나타낸다. 시작점은 S, 도착점은 D로 표시되어 있다. 
//굵은 선은 최단 경로를 나타낸다. (아래 그림에 최단 경로는 두 개가 있다)거의 최단 경로는 점선으로 표시된 경로이다. 
//이 경로는 최단 경로에 포함되지 않은 도로로 이루어진 경로 중 가장 짧은 경로이다. 거의 최단 경로는 여러 개 존재할 수도 있다. 
//예를 들어, 아래 그림의 길이가 3인 도로의 길이가 1이라면, 거의 최단 경로는 두 개가 된다. 또, 거의 최단 경로가 없는 경우도 있다.
//입력
//입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 장소의 수 N (2 ≤ N ≤ 500)과 
//도로의 수 M (1 ≤ M ≤ 104)가 주어진다. 장소는 0부터 N-1번까지 번호가 매겨져 있다. 둘째 줄에는 시작점 S와 도착점 D가 주어진다.
//(S ≠ D; 0 ≤ S, D < N) 다음 M개 줄에는 도로의 정보 U, V, P가 주어진다. 
//(U ≠ V ; 0 ≤ U, V < N; 1 ≤ P ≤ 103) 이 뜻은 U에서 V로 가는 도로의 길이가 P라는 뜻이다. 
//U에서 V로 가는 도로는 최대 한 개이다. 또, U에서 V로 가는 도로와 V에서 U로 가는 도로는 다른 도로이다. 
//입력의 마지막 줄에는 0이 두 개 주어진다.
//출력
//각 테스트 케이스에 대해서, 거의 최단 경로의 길이를 출력한다. 만약, 거의 최단 경로가 없는 경우에는 -1을 출력한다.
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
