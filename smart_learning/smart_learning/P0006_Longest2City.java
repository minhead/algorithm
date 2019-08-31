package smart_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P0006_Longest2City {

	static int w[][];
	static int T,N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=2;
		N=4;
		
		w = new int[N+1][N+1];
		for(int i =1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
				w[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int k = 1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
					w[i][j] = Math.min(w[i][j], w[i][k]+w[k][j]);
		int ans = 0;
		for(int i=1;i<=N;i++)
			for(int j =1;j<=N;j++)
				ans = Math.max(ans, w[i][j]);
		System.out.println();

	}

}
