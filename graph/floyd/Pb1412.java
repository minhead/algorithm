package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//�Ϲ�����
//����
//�ټ������� �� �̴ټ��� ȭ�� ����. �׷��� �ڽ��� ������ ��� ���� �ٲٷ��� �Ѵ�.
//���� �ټ��������� ���� ���� ������ �ִ�. ������ ������ �Ϲ������� ���γ� ��������� ���η� ����Ǿ� �ִ�.
// �̴ټ��� ��ǥ�� ��������� ���θ� ��� �Ϲ��������� �ٲٴ� ���̴�. �� ���� ��������� ���θ� �� ���� ���� �� �ϳ��� �����ϴ� ���̴�.
//�̴ټ��� �ñ����� ��ǥ�� ��������� ���θ� ��� �Ϲ��������� �ٲ㼭 ������ ���� x���� ����ؼ� �ٽ� �� ���� x�� ���ƿ� �� ���� ����� ���̴�.
//������ ������ �־����� ��, �̴ټ��� ��ǥ�� ��õ�� �� �ִ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//�Է�
//ù° �ٿ� ������ ���� N(1<N<100) �� �־�����.  ��° �ٺ��� N���� �ٿ� ������ ������ �־�����.
// �������ó�� �־�����. N�� M���� ����Ű�� ������ Y �Ǵ� N�ε�, Y�� ����, N->M���� ���� ���ΰ� �ִٴ� �Ҹ���, N�� ����, ���ٴ� �Ҹ���.
//���
//�̴ټ��� ��ǥ�� ��õ�� �� ������ YES, ������ NO�� ����Ѵ�.
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
			if (visited[node] == -1) {// ����Ŭ
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
