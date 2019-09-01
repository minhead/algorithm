package cutPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//������
//�׷����� �־����� ��, �������� ��� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//�������̶� �� ������ �������� ��, �׷����� �� �� �Ǵ� �� �̻����� ���������� ������ ���Ѵ�. ��, �������� �� �׷����� connected component�� ������ �����ϴ� ������ ���Ѵ�
//�ƹ� �������� �����ص� ������ ���⼭�� ���� ��带 1�� ���� ��� �����ϱ⿡ 1���� �湮 ������ 1�̴�.
//���� �ռ� ���ߴ� ���� Ư���� ����ؼ� �� ��ȣ���� ��� ���� �����غ���.
//Ư�� A�� �������� �ڽ� ������ ���� A�� ��ġ�� �ʰ� ���� A���� ���� �湮��ȣ�� ���� �������� �� �� ���ٸ� �������̴�.
//DFS Spanning Tree �˰���� �׿� ���� Ȱ���� �� �ִ� ���� ���� ����  
//�������� Ư¡�� �����ϴµ� �ټ� �ð��� ���� �ɷȴ�. ó������ �ܼ��� DFS�� ��� ��츦 Ž���ߴµ� �ð��ʰ��� �߻��ߴ�.
//Spanning Tree�� ������ ��Ʈ üũ�� ���� �ʿ��߰� ���� �׷����� ��� ���Ǵ� ���� �������־�� �Ѵ�.
//Spanning Tree�� Ž���ϸ鼭 �湮�� ������ ���� ���� �� �ϳ��� �湮�� ������ ���� ������ ������ �� �� ���� ��� �������ƴϴ�. 
//�̶� ���������� Spanning Tree�� Ž���ϴ� ��찡 �ǰ� ���������� ���� ���� Ȯ���ϴ� ���� ���� �׷����� �̿��ؾ� �Ѵ�. 
public class Pb11266 {
	static int V;
	static int E;
	static int count = 1;
	static int[] visited;
	static boolean[] isCutVertax;

	static class Node {
		int adjVertax;
		public Node(int adjVertax) {
			super();
			this.adjVertax = adjVertax;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new int[V + 1];
		isCutVertax = new boolean[V + 1];
		ArrayList<Node>[] list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b));
			list[b].add(new Node(a));
		}
        for(int i = 1; i <=V ;i ++) {
            if(visited[i] == 0) {
                dfs(i, true, list);
            }
        }
        int cnt = 0;
        for(int i = 1; i <= V ; i++) {
            if(isCutVertax[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
        for(int i = 1; i <= V ; i++) {
            if(isCutVertax[i]) {
                System.out.print(i +" ");
            }
        }

	}

	private static int dfs(int vertax, boolean root, ArrayList<Node>[] list) {
		/* �ڱ⺸�� �տ� Ž���Ҽ� �ִ� ��찡 ������ �������� ���� �ʴ´�. */
		/* DFS���д�Ʈ���� ����鼭 ���� Ʈ���� �״�� ���� �������� ���� �ƴ� */
		/*
		 * DFS���д� Ʈ���� ������ ������ ������ �ִ� �Ͱ� DFS���д� Ʈ������ ��Ʈ�� �ڽ��� 2�� �������� üũ
		 */

		visited[vertax] = count++;
		int ret = visited[vertax]; // �ڱ�� ������� �߿��� ���� ���� �湮�Ǵ� ����� ������ �����ϴ� ����
		int child = 0; // ��Ʈ ����� ��� ���д�Ʈ������ �ڽļ�
		for (int i = 0; i < list[vertax].size(); i++) {
			if (visited[list[vertax].get(i).adjVertax] == 0) {
				child++;

				int low = dfs(list[vertax].get(i).adjVertax, false, list);
				// �ڽ� ��尡 ���� �ִ� ����� ���� ���� �湮�� ���
				// �߰��� dfs �Ѵٴ� ���� ������ ������ ���ٴ� ���� �ǹ�

				if (!root && low >= visited[vertax]) {
					isCutVertax[vertax] = true;
				} // low�� �ڱ��� �������� �ʰų� ���� ����
					// �� �ڱ⺸�� �տ� �ִ� ��δ� �ڱ⸦ ���ؼ� �ۿ� ������. ������

				ret = Math.min(ret, low);
			} else {
				ret = Math.min(ret, visited[list[vertax].get(i).adjVertax]);
				// �̹� �湮�� ������ ret�� �� �ּҰ� ����
			}
		}

		if (root && child >= 2) {
			isCutVertax[vertax] = true;
		} // ��Ʈ�� ���� ������� Ȯ���� ���� ���� ������ ���д� Ʈ������
			// �ڽ��� �ΰ� �ִٴ� ���� �������̴�.

		return ret;
	}

}
