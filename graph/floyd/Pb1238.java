package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.
//어느 날 이 N명의 학생이 X (1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다. 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.
//각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다. 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.
//이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다. N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
//입력
//첫째 줄에 N(1 <= N <= 1,000), M(1 <= M <= 10,000), X가 공백으로 구분되어 입력된다. 두 번째 줄부터 M+1번째 줄까지 i번째 도로의 시작점, 끝점, 그리고 이 도로를 지나는데 필요한 소요시간 Ti가 들어온다.
//모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.
//출력
//첫 번째 줄에 N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간을 출력한다.
public class Pb1238 {
	static int N, M, X; // N : 학생수 M : 도로개수 X: 파티가 열리는 마을 번호
	static int map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for(int i =1;i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(i==j)
					continue;
				map[i][j]=1000000;
			}
		}

		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], value);
		}
		for (int mid = 1; mid <= N; mid++) {
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					map[start][end] = Math.min(map[start][end], map[start][mid] + map[mid][end]);
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			result = Math.max(result, map[i][X] + map[X][i]);
		}
		System.out.println(result);

	}

}
