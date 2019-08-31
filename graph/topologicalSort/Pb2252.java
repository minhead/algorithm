package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import data_structure.PriorityQ;

/**
N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 
그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오
첫째 줄에 N(1≤N≤32,000), M(1≤M≤100,000)이 주어진다.
M은 키를 비교한 회수이다. 
다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다. 
이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.
학생들의 번호는 1번부터 N번이다. **/
//위상 정렬은 그래프 정렬을 말합니다.
//그래프의 순서를 정렬하기 때문에 조건이 있습니다.
//위상 정렬이 가능하려면 DAG(Directed Acyclic Graph, 방향성이 있으며 사이클이 없는 그래프)여야 합니다.
//1) 말 그래도 두 노드 A, B 사이에 A -> B 같은 관계가 성립되어야 하며 
//2) A -> B, B <- A 처럼 그래프들 사이에 사이클이 없어야 합니다.
//위상정렬은 DFS를 사용하여 구현하거나 indegree 배열을 사용하여 구현 할 수 있습니다.
//indegree : 노드로 들어가는 간선이 몇개있는지 배열에 담는다
public class Pb2252 {
	
	static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		Queue<Integer> que = new LinkedList<Integer>();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int indegree[] = new int[N+1];
		for(int i = 1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			indegree[to]=indegree[to]+1;					
		}
		for(int i = 1;i<=N;i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		Queue<Integer> result = new LinkedList<>();
		while(!que.isEmpty()) {
			int p = que.poll();
			result.add(p);
			for(int i = 0;i<list[p].size();i++) {
				int end = list[p].get(i);
				indegree[end]--;
				if(indegree[end]==0)
					que.add(end);
			}
		}
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
	}

}
