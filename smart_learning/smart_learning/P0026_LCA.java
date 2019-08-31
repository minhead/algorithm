package smart_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P0026_LCA {

	static int N, Q;
	static int par[][];
	static ArrayList<Integer>[] con;
	static int depth[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		par = new int[N + 1][17];
		con = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			con[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 2; i <= N; i++) {
			par[i][0] = Integer.parseInt(st.nextToken());
			con[par[i][0]].add(i);
		}
		for (int i = 1; i < 17; i++)
			for (int j = 1; j <= N; j++)
				par[j][i] = par[par[j][i - 1]][i - 1];

		// 깊이계산
		depth = new int[N + 1];
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		while (!que.isEmpty()) {
			int q = que.poll();
			for (int t : con[q]) {
				depth[t] = depth[q] + 1;
				que.add(t);
			}
		}
		for(int i=1;i<=Q;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.print(" "+lca(a,b));
		}
		System.out.println();

	}

	static int lca(int a, int b) {
		//1. a의 depth가 b의 depth보다 얕지 않게한다
		if (depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		//2.a와 b의 depth가 같아지도록 a를 위로 올린다
		for (int i = 0; i < 17; i++)
			if (((1 << i) & (depth[a] - depth[b])) != 0)
				a = par[a][i];
		//3. a와 b가 같다면 lca(a,b)는 a임
		if (a == b)
			return a;
		//4. a와 b가 같지않을 때까지 올린다
		for (int i = 17; i-- > 0;)//i=16부터 0까지 반복
			if (par[a][i] != par[b][i]) {
				a = par[a][i];
				b = par[b][i];
			}
		//5. lca(a,b) = parent[a][0]
		return par[a][0];

	}

}
