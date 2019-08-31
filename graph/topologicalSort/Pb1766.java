package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pb1766 {
	static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<Integer>();
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
