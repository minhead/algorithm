package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sw_Sep {
	static final int INF = Integer.MAX_VALUE;
	static int N, M,start,end;
	static int par[];

	static class Edge {
		int from;
		int to;
		int value;

		Edge(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
	}

	static ArrayList<Edge> list;

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList<Edge>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new Edge(a, b, c));
//				list.add(new Edge(b, a, c));
			}
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			Collections.sort(list, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					// TODO Auto-generated method stub
					return o1.value - o2.value;
				}
			});
			par = new int[N + 1];
			long ret = Long.MAX_VALUE;
			for(int i = 0 ; i<list.size();i++) {
				System.out.println(list.get(i).value);
			}
			
			for (int i = 0; i < list.size(); i++) {
				ret = Math.min(ret, minUpperBound(i) - list.get(i).value);
			}
			System.out.println("#" + test_case + " " + ret);

		}

	}

	static long minUpperBound(int l) {
		for (int i = 1; i <= N; i++) {
			par[i] = i;
		}
		int low = list.get(l).value;
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).value < low)
				continue;
			int a = find(list.get(i).from);
			int b = find(list.get(i).to);
			if(a==b)
				continue;
			par[b] = a;
			max = Math.max(max, list.get(i).value);
			if(find(start)==find(end))
				return max;
		}
		return Long.MAX_VALUE;
	}
	static int find(int n) {
		if(par[n]==n) {
			return n;
		}
		return par[n] = find(par[n]);
	}

}
