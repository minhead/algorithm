package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N���� ���ڷ� ���е� ������ ������ �� ���� �л��� ��� �ִ�.
//��� �� �� N���� �л��� X (1 �� X �� N)�� ������ �𿩼� ��Ƽ�� ���̱�� �ߴ�. �� ���� ���̿��� �� M���� �ܹ��� ���ε��� �ְ� i��° ���� �����µ� Ti(1 �� Ti �� 100)�� �ð��� �Һ��Ѵ�.
//������ �л����� ��Ƽ�� �����ϱ� ���� �ɾ�� �ٽ� �׵��� ������ ���ƿ;� �Ѵ�. ������ �� �л����� ���� �������� �ִ� �ð��� ���� ���⸦ ���Ѵ�.
//�� ���ε��� �ܹ����̱� ������ �Ƹ� �׵��� ���� ���� ���� �ٸ����� �𸥴�. N���� �л��� �� ���� ���µ� ���� ���� �ð��� �Һ��ϴ� �л��� �������� ���Ͽ���.
//�Է�
//ù° �ٿ� N(1 <= N <= 1,000), M(1 <= M <= 10,000), X�� �������� ���еǾ� �Էµȴ�. �� ��° �ٺ��� M+1��° �ٱ��� i��° ������ ������, ����, �׸��� �� ���θ� �����µ� �ʿ��� �ҿ�ð� Ti�� ���´�.
//��� �л����� ������ X�� ���� �ְ�, X���� ������ ���ƿ� �� �ִ� �����͸� �Է����� �־�����.
//���
//ù ��° �ٿ� N���� �л��� �� ���� ���µ� ���� ���� �ɸ��� �л��� �ҿ�ð��� ����Ѵ�.
public class Pb1238 {
	static int N, M, X; // N : �л��� M : ���ΰ��� X: ��Ƽ�� ������ ���� ��ȣ
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
