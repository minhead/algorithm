package smart_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
//최소신장트리 MST
public class P0007_MinGrowthTree {
	private static class Edge {
		int a, b, c;

		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

	}

	static int par[];
	static int N;
	static int M;
	static int K;
	static int a, b, c;

	static int find(int n) { // 경로압축
		if (par[n] == n) {
			return n;
		}
		return par[n] = find(par[n]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //도시의 수 
			M = Integer.parseInt(st.nextToken()); //지금 존재하는 도로의 수
			K = Integer.parseInt(st.nextToken()); //건설가능한 도로의 수

//간선을 저장하는 Arraylist
			ArrayList<Edge> edges = new ArrayList<>();
			long ans = 0;
			for (int i = 1; i <= M; i++) {//기존에 존재하는 도로 M개에 대해 abc 입력
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b, -c)); //도로를 제거하는 비용 c, 이 도로를 채택하는 경우 도로를 제거 안해도 되므로 비용이 -임
				ans = ans + c; //기존 도로를 모두 제거해놓고 시작하기때문에 비용에 c를 더함
			}
			for (int i = 1; i <= K; i++) {// 건설가능한 도로 리스트 생성
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b, c));
			}
			//정점 정렬하기
			Collections.sort(edges, new Comparator<Edge>() {
				public int compare(Edge a, Edge b) {
					return a.c -b.c;
				}
			});
			
			par = new int[N+1]; //노드 배열 만들기
			for(int i = 1; i<=N; i++) {
				par[i] = i;//배열의 각 인덱스에 각 번호의 노드에대한 집합 담는다.
			}
			for(Edge e: edges) { // UNION ..모든 간선에서  
				int a = find(e.a); //각 집합의 최종 부모노드를 a에 담는다
				int b= find(e.b); //각 집합의 최종 부모노드를 b에 담는다
				if(a==b) //맨 위 부모노드가 같다면 같은집합이므로
					continue; // 해당 간선은 선택되지 않는다
				par[b] = a;
				ans = ans+e.c; //간선이 선택되면 ans에 비용처리를 한다.
						
			}
			
			System.out.println("#"+test_case+" "+ans);
		}

	}
}