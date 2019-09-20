package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//일방통행
//문제
//다솜제국의 왕 이다솜은 화가 났다. 그래서 자신의 나라의 모든 길을 바꾸려고 한다.
//현재 다솜제국에는 여러 개의 마을이 있다. 각각의 마을은 일방통행인 도로나 양방통행인 도로로 연결되어 있다.
// 이다솜의 목표는 양방통행인 도로를 모두 일방통행으로 바꾸는 것이다. 이 말은 양방통행인 도로를 두 개의 방향 중 하나로 선택하는 것이다.
//이다솜의 궁극적인 목표는 양방통행인 도로를 모두 일방통행으로 바꿔서 임의의 도시 x에서 출발해서 다시 그 도시 x로 돌아올 수 없게 만드는 것이다.
//도로의 정보가 주어졌을 때, 이다솜의 목표를 실천할 수 있는지 없는지 구하는 프로그램을 작성하시오.
//입력
//첫째 줄에 도시의 개수 N(1<N<100) 이 주어진다.  둘째 줄부터 N개의 줄에 도로의 정보가 주어진다.
// 인접행렬처럼 주어진다. N행 M열이 가르키는 정보는 Y 또는 N인데, Y일 때는, N->M으로 가는 도로가 있다는 소리고, N일 때는, 없다는 소리다.
//출력
//이다솜의 목표를 실천할 수 있으면 YES, 없으면 NO를 출력한다.
public class Pb1412 {

	static int N;
	static int arr[][];
	static int visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String st = br.readLine();
			for (int j = 1; j <= N; j++) {
				if (st.substring(j-1,j).equals("Y")) {
					if (arr[i][j] == 0) {
						arr[j][i] = 1;
					}
					
				}else {
					arr[j][i] = 0;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			visited = new int[N + 1];
			if (findCycle(i)) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");

	}

	static boolean findCycle(int node) {
		if (visited[node] != 0) {
			if (visited[node] == -1) {// 싸이클
				return true;
			}
			return false;
		}
		visited[node] = -1;
		for (int i = 1; i <= N; i++) {
			if (arr[node][i] == 1) {
				if (findCycle(i)) {
					return true;
				}
			}
		}
		visited[node] = 1;
		return false;
	}

}
