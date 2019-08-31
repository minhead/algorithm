package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import data_structure.PriorityQ;

/**
N���� �л����� Ű ������� ���� ������� �Ѵ�. �� �л��� Ű�� ���� �缭 �����ϸ� �����ϰ�����, ������ ����� ��� �� �л��� Ű�� ���ϴ� ����� ����ϱ�� �Ͽ���. 
�׳����� ��� �л����� �� ���� �� ���� �ƴϰ�, �Ϻ� �л����� Ű���� ���� ���Ҵ�.
�Ϻ� �л����� Ű�� ���� ����� �־����� ��, ���� ����� ���α׷��� �ۼ��Ͻÿ�
ù° �ٿ� N(1��N��32,000), M(1��M��100,000)�� �־�����.
M�� Ű�� ���� ȸ���̴�. 
���� M���� �ٿ��� Ű�� ���� �� �л��� ��ȣ A, B�� �־�����. 
�̴� �л� A�� �л� B�� �տ� ���� �Ѵٴ� �ǹ��̴�.
�л����� ��ȣ�� 1������ N���̴�. **/
//���� ������ �׷��� ������ ���մϴ�.
//�׷����� ������ �����ϱ� ������ ������ �ֽ��ϴ�.
//���� ������ �����Ϸ��� DAG(Directed Acyclic Graph, ���⼺�� ������ ����Ŭ�� ���� �׷���)���� �մϴ�.
//1) �� �׷��� �� ��� A, B ���̿� A -> B ���� ���谡 �����Ǿ�� �ϸ� 
//2) A -> B, B <- A ó�� �׷����� ���̿� ����Ŭ�� ����� �մϴ�.
//���������� DFS�� ����Ͽ� �����ϰų� indegree �迭�� ����Ͽ� ���� �� �� �ֽ��ϴ�.
//indegree : ���� ���� ������ ��ִ��� �迭�� ��´�
public class Pb2252 {
	
	static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		Queue<Integer> que = new LinkedList<Integer>();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int indegree[] = new int[N+1];
		for(int i = 1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			indegree[to]=indegree[to]+1;					
		}
		for(int i = 1;i<=N;i++) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}
		Queue<Integer> result = new LinkedList<>();
		while(!que.isEmpty()) {
			int p = que.poll();
			result.add(p);
			for(int i = 0;i<list[p].size();i++) {
				int end = list[p].get(i);
				indegree[end]--;
				if(indegree[end]==0)
					que.add(end);
			}
		}
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
	}

}
