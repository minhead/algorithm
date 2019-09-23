package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//n(1 ≤ n ≤ 100)개의 도시가 있다. 
//그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 
//각 버스는 한 번 사용할 때 필요한 비용이 있다.
//모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.
//입력
//첫째 줄에 도시의 개수 n(1 ≤ n ≤ 100)이 주어지고 둘째 줄에는 버스의 개수 m(1 ≤ m ≤ 100,000)이 주어진다.
//그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다.
//먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
//버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
//시작 도시와 도착 도시가 같은 경우는 없다.
//비용은 100,000보다 작거나 같은 자연수이다.
//시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
//출력
//N개의 줄을 출력해야 한다. 
//i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다.
//약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.
public class Pb11404 {

	static int n;
	static int m;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		StringTokenizer st;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 거리증 최소값으로 입력
			if (arr[a][b] == 0) {
				arr[a][b] = c;
			} else {
				arr[a][b] = Math.min(c, arr[a][b]);
			}
		}

		for (int mid = 1; mid <= n; mid++) {
			for (int start = 1; start <= n; start++) {
				if (arr[start][mid] == 0)
					continue;
				for (int end = 1; end <= n; end++) {
					if (arr[mid][end] == 0 || start == end)
						continue;

					if (arr[start][end] == 0 || arr[start][end] > arr[start][mid] + arr[mid][end]) {
						arr[start][end] = arr[start][mid] + arr[mid][end];
					}

				}
			}
		}

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y < = n; y++) {
				System.out.print(arr[x][y]+" ");
			}
			System.out.println();
		}

	}

}
