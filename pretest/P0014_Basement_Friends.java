package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P0014_Basement_Friends {
	static int N, K;
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for (int i = 1; i <= N; i++) {
				int k = Integer.parseInt(st.nextToken());
				list[k].add(i);
			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 0; j < list[i].size(); j++)
//					System.out.print(i + ", " + list[i].get(j) + " ");
//			}
//			System.out.println();

			Queue<Integer> q;
//			for(int i = 1; i<=N;i++) {
//				if(list[i].size()==0) {
//					q.add(i);
//				}
//			}
			int visited[];
			int answer = 0;
			for (int i = 1; i <= N; i++) {// 각 굴에 대해서 인원 센다
				q = new LinkedList<Integer>();
				visited = new int[N + 1];
				int count = K;
//				for (int j = 1; j < K; j++) {// 지날 수 있는 굴의 최대갯수 K
				if (list[i].size() < 1) {
					continue;
				}
				int idx;
				for (int u = 0; u < list[i].size(); u++) {
					idx = list[i].get(u);
					q.add(idx);
				}
				while (count > 0 && !q.isEmpty()) {
					idx = q.poll();

					for (int m = 0; m < list[idx].size(); m++) {

						int dd = list[idx].get(m);
						if (visited[dd] == 0 && dd != i) {
							visited[dd] = 1;
						}
						q.add(list[idx].get(m));
						
					}
					count--;

				}
//				}
				for (int e = 1; e <= N; e++) {
					if (visited[e] == 1)
						answer++;
				}
			}

			System.out.println("#" + test_case + " " + answer);

		}

	}

}
