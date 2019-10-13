package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P0067_Biggest_ShortestPath {
	static int N, erase[];
	static long arr[][];
	static long INF = Long.MAX_VALUE;

	static class Edge {
		int end;
		int value;

		Edge(int end, int value) {
			this.end = end;
			this.value = value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			erase = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				erase[i] = Integer.parseInt(st.nextToken());
			}
			arr = new long[N + 1][N + 1];
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = i + 1; j <= N; j++) {
					int a = Integer.parseInt(st.nextToken());
					if (a == 0) {
						arr[i][j] = INF;
						arr[j][i] = INF;
						continue;
					}
					arr[i][j] = a;
					arr[j][i] = a;
				}
			}

			long result = 0;

			System.out.print("#" + test_case + " ");
			floyd();
			result = findMax(0);
			System.out.print(result + " ");
			for (int i = 1; i < N; i++) {
				deleteOne(erase[i]);
//				floyd();
				result = findMax(0);
				System.out.print(result + " ");

			}
			System.out.println();

		}

	}

	static void floyd() {
		for (int mid = 1; mid <= N; mid++) {
			for (int start = 1; start <= N; start++) {
				if (start == mid || arr[start][mid] == INF)
					continue;
				for (int end = 1; end <= N; end++) {
					if (start == end || arr[mid][end] == INF)
						continue;
					arr[start][end] = Math.min(arr[start][end], arr[start][mid] + arr[mid][end]);
				}
			}
		}
	}

	static void deleteOne(int k) {
		for (int i = 1; i <= N; i++) {
			arr[i][k] = INF;
			arr[k][i] = INF;
		}
		
		for (int start = 1; start <= N; start++) {
			if (start == k || arr[start][k] == INF)
				continue;
			for (int end = 1; end <= N; end++) {
				if (start == end || arr[k][end] == INF)
					continue;
				arr[start][end] = Math.min(arr[start][end], arr[start][k] + arr[k][end]);
			}
		}
		
		
		
		
		
	}

	static long findMax(long result) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] != INF) {
					result = Math.max(result, arr[i][j]);
				}

			}
		}
		return result;
	}
}
