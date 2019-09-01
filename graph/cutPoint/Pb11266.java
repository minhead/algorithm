package cutPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//단절점
//그래프가 주어졌을 때, 단절점을 모두 구해 출력하는 프로그램을 작성하시오.
//단절점이란 그 정점을 제거했을 때, 그래프가 두 개 또는 그 이상으로 나누어지는 정점을 말한다. 즉, 제거했을 때 그래프의 connected component의 개수가 증가하는 정점을 말한다
//아무 정점부터 시작해도 되지만 여기서는 최초 노드를 1번 노드로 잡고 시작하기에 1번이 방문 순서가 1이다.
//이제 앞서 말했던 위의 특성을 사용해서 이 번호들을 어떻게 쓸지 생각해보자.
//특정 A번 정점에서 자식 노드들이 정점 A를 거치지 않고 정점 A보다 빠른 방문번호를 가진 정점으로 갈 수 없다면 단절점이다.
//DFS Spanning Tree 알고리즘과 그에 대한 활용할 수 있는 지에 대한 문제  
//단절점의 특징을 이해하는데 다소 시간이 많이 걸렸다. 처음에는 단순히 DFS로 모든 경우를 탐색했는데 시간초과가 발생했다.
//Spanning Tree는 순서와 루트 체크를 위해 필요했고 기존 그래프를 계속 사용되는 것을 생각해주어야 한다.
//Spanning Tree로 탐색하면서 방문한 정점의 인접 정점 중 하나라도 방문한 정점의 이전 순서의 정점로 갈 수 있을 경우 단절점아니다. 
//이때 이전순서는 Spanning Tree로 탐색하는 경우가 되고 이전순서로 가는 것을 확인하는 경우는 기존 그래프를 이용해야 한다. 
public class Pb11266 {
	static int V;
	static int E;
	static int count = 1;
	static int[] visited;
	static boolean[] isCutVertax;

	static class Node {
		int adjVertax;
		public Node(int adjVertax) {
			super();
			this.adjVertax = adjVertax;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new int[V + 1];
		isCutVertax = new boolean[V + 1];
		ArrayList<Node>[] list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b));
			list[b].add(new Node(a));
		}
        for(int i = 1; i <=V ;i ++) {
            if(visited[i] == 0) {
                dfs(i, true, list);
            }
        }
        int cnt = 0;
        for(int i = 1; i <= V ; i++) {
            if(isCutVertax[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
        for(int i = 1; i <= V ; i++) {
            if(isCutVertax[i]) {
                System.out.print(i +" ");
            }
        }

	}

	private static int dfs(int vertax, boolean root, ArrayList<Node>[] list) {
		/* 자기보다 앞에 탐색할수 있는 경우가 있으면 단절점이 되지 않는다. */
		/* DFS스패닝트리를 만들면서 기존 트리는 그대로 사용됨 없어지는 것이 아님 */
		/*
		 * DFS스패닝 트리의 역할은 순서를 지정해 주는 것과 DFS스패닝 트리에서 루트가 자식을 2개 가지는지 체크
		 */

		visited[vertax] = count++;
		int ret = visited[vertax]; // 자기랑 인접노드 중에서 가장 빨리 방문되는 노드의 순서를 저장하는 변수
		int child = 0; // 루트 노드일 경우 스패닝트리에서 자식수
		for (int i = 0; i < list[vertax].size(); i++) {
			if (visited[list[vertax].get(i).adjVertax] == 0) {
				child++;

				int low = dfs(list[vertax].get(i).adjVertax, false, list);
				// 자식 노드가 갈수 있는 노드중 가장 일찍 방문한 노드
				// 중간에 dfs 한다는 것은 정점의 끝까지 간다는 것을 의미

				if (!root && low >= visited[vertax]) {
					isCutVertax[vertax] = true;
				} // low가 자기의 순서보다 늦거나 같은 경우는
					// 즉 자기보다 앞에 있는 경로는 자기를 통해서 밖에 못간다. 단절점

				ret = Math.min(ret, low);
			} else {
				ret = Math.min(ret, visited[list[vertax].get(i).adjVertax]);
				// 이미 방문한 정점과 ret값 비교 최소값 저장
			}
		}

		if (root && child >= 2) {
			isCutVertax[vertax] = true;
		} // 루트는 위의 방법으로 확인할 수가 없기 때문에 스패닝 트리에서
			// 자식이 두개 있다는 것은 단절점이다.

		return ret;
	}

}
