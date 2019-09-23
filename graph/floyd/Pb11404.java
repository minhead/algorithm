package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//����
//n(1 �� n �� 100)���� ���ð� �ִ�. 
//�׸��� �� ���ÿ��� ����Ͽ� �ٸ� ���ÿ� �����ϴ� m(1 �� m �� 100,000)���� ������ �ִ�. 
//�� ������ �� �� ����� �� �ʿ��� ����� �ִ�.
//��� ������ �� (A, B)�� ���ؼ� ���� A���� B�� ���µ� �ʿ��� ����� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//�Է�
//ù° �ٿ� ������ ���� n(1 �� n �� 100)�� �־����� ��° �ٿ��� ������ ���� m(1 �� m �� 100,000)�� �־�����.
//�׸��� ��° �ٺ��� m+2�ٱ��� ������ ���� ������ ������ �־�����.
//���� ó������ �� ������ ��� ������ ��ȣ�� �־�����.
//������ ������ ������ ���� ���� a, ���� ���� b, �� �� Ÿ�µ� �ʿ��� ��� c�� �̷���� �ִ�.
//���� ���ÿ� ���� ���ð� ���� ���� ����.
//����� 100,000���� �۰ų� ���� �ڿ����̴�.
//���� ���ÿ� ���� ���ø� �����ϴ� �뼱�� �ϳ��� �ƴ� �� �ִ�.
//���
//N���� ���� ����ؾ� �Ѵ�. 
//i��° �ٿ� ����ϴ� j��° ���ڴ� ���� i���� j�� ���µ� �ʿ��� �ּ� ����̴�.
//��, i���� j�� �� �� ���� ��쿡�� �� �ڸ��� 0�� ����Ѵ�.
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

			// �Ÿ��� �ּҰ����� �Է�
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
