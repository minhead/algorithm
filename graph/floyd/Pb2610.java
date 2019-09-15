package floyd;
// ȸ���غ�

//����ȸ���� ��� �����ڵ��� �ǻ����޽ð� �� �ִ��� �ּҰ� �ǵ��� ��ǥ�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//�Է�
//ù° �߿� ȸ�ǿ� �����ϴ� ����� �� N�� �־�����.
// �����ڵ��� 1���� N������ �ڿ����� ǥ���Ǹ� ȸ�ǿ� �����ϴ� �ο��� 100 �����̴�. 
// ��° �ٿ��� ���� �˰� �ִ� ������ �� M�� �־�����. 
// �̾� M���� �� �ٿ��� ���� �ƴ� ������ �����ڸ� ��Ÿ���� �ΰ��� �ڿ����� �־�����.
//���
//ù° �ٿ��� �����Ǵ� ����ȸ�� �� K�� ����Ѵ�. 
//���� K�ٿ��� �� ����ȸ�� ��ǥ ��ȣ�� ���� ������ ���ʷ� �� �ٿ� �ϳ��� ����Ѵ�. 
//�� ����ȸ�� ��ǥ�� �� �� �ִ� ����� �� �̻��� ��� ���� �� �� ����ϸ� �ȴ�.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Pb2610 {
	// ���Ѵ� ���
	private static final int INFINITE = 101;

	// ���� ���� ���
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// ���۸� ���� �Է� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// ����ġ ���� �迭 �ʱ�ȭ
		int[][] matrix = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					matrix[i][j] = INFINITE;
				}
			}
		}

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			matrix[i][j] = matrix[j][i] = 1;
		}

		br.close();

		// �÷��̵� �ͼ� �˰����� ���� �ּ� ����ġ�� ����
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
		}

		// �׷� ���� �迭 ����Ʈ �迭 �ʱ�ȭ
		ArrayList<Integer>[] groups = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			groups[i] = new ArrayList<>();
		}

		// �湮 ���� ���� �迭 �ʱ�ȭ
		boolean[] isVisited = new boolean[N + 1];

		// ������ ���� �� �׷쿡 �ش��ϴ� ������� �з��Ͽ� �׷� ���� �迭 ����Ʈ �迭�� �߰�
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (matrix[i][j] != INFINITE && !isVisited[j]) {
					isVisited[j] = true;
					groups[i].add(j);
				}
			}
		}

		// �׷� ���� ���� ���� �ʱ�ȭ
		int K = 0;

		// ��ǥ�� �ε��� ���� �迭 ����Ʈ �ʱ�ȭ
		ArrayList<Integer> groupLeaderIdxs = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			// �ش� �׷쿡 ����� 1���̶� ���� ��쿡��
			if (groups[i].size() != 0) {
				// �׷� ���� 1 ����
				K++;

				// ���� �ָ� �������ִ� ������� ����ġ�� ���� ���� ��, �� �ε����� �����ϴ� ���� �ʱ�ȭ
				int min = Integer.MAX_VALUE;
				int minIdx = 0;

				// �׷쳻 �� ����� �������� ���� �ָ� �������ִ� ������� ����ġ�� ����
				for (int start : groups[i]) {
					int max = Integer.MIN_VALUE;

					for (int end : groups[i]) {
						max = Math.max(max, matrix[start][end]);
					}

					// ����ġ�� �� ���� ��츦 �߰��ϸ� ���� ����
					if (max < min) {
						min = max;
						minIdx = start;
					}
				}

				// �ش� �׷��� ��ǥ�� �ε��� ���� �迭�� ã�� ��ǥ���� �ε����� �߰�
				groupLeaderIdxs.add(minIdx);
			}
		}

		// ��ǥ�� �ε��� ���� �迭 ������������ ����
		Collections.sort(groupLeaderIdxs);

		// ���۸� ���� ��� ���� ����
		StringBuilder sb = new StringBuilder();
		sb.append(K).append(NEW_LINE);

		for (int groupLeaderIdx : groupLeaderIdxs) {
			sb.append(groupLeaderIdx).append(NEW_LINE);
		}

		// ��� �� �Ѳ����� ���
		System.out.println(sb.toString());
	}
}
