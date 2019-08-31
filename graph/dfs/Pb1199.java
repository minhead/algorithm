package dfs;
//오일러 회로
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pb1199 {

	static int N;
	static int arr[][];
	static int EdgeCount[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		StringTokenizer st;
		int Answer = 0;
		EdgeCount = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				EdgeCount[i] += arr[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			if (EdgeCount[i] % 2 != 0) {
				Answer = -1;
				break;
			}

		}
		if (Answer == -1) {
			System.out.println("-1");
		} else {
			Euler(1);

		}

	}

	static void Euler(int x) {
		for (int i = 1; i <= N; i++) {
			if (arr[x][i] != 0) {
				arr[x][i]--;
				arr[i][x]--;
				Euler(i);
			}
		}
		System.out.print(x + " ");
	}

}
