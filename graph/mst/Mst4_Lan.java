package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


//2
//3 1
//0 0 1
//0 1 2
//0 1
//10 5
//-7 -7 10 -4 10 -4 -5 0 -10 -6
//6 8 -5 3 -4 6 -10 4 -7 10
//9 7
//7 3
//9 7
//5 0
//8 6


public class Mst4_Lan {
	static int N, M;
	static ArrayList<Edge> list;
	static int par[];

	static class Edge {
		int from;
		int to;
		double value;

		Edge(int from, int to, double value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int x[] = new int[N];
			int y[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			list = new ArrayList<Edge>();
			par = new int[N];
			for (int i = 0; i < N; i++) {
				par[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				par [b]= a;
//				double value = (x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b]);
//				list.add(new Edge(a, b, value));
//				list.add(new Edge(b, a, value));
			}
			for(int i=0;i<N-1;i++) {
				for(int j=1;j<N;j++) {
					if(i==j)
						continue;
					int a = i;
					int b = j;
					double value = (x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b]);
					list.add(new Edge(a, b, value));
					list.add(new Edge(b, a, value));
				}
			}
			
			
			Collections.sort(list, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					// TODO Auto-generated method stub
					return (int) (o1.value-o2.value);
				}

			});

			double max = 0;
			for (int i = 0; i < list.size(); i++) {
				int a = find(list.get(i).from);
				int b = find(list.get(i).to);
				double c = Math.sqrt(list.get(i).value);
				if (a == b)
					continue;
				par[b] = a;
				max = max + c;

			}
			System.out.println(max);
		}

	}

	static int find(int n) {
		if (par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}

}
