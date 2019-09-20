package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//�˰��� ���� (https://algospot.com/judge/problem/read/ROUTING)
//�� �׸��� ���� ���� ��ǻ�͵�� �� ��ǻ�͵��� �մ� ȸ���� ��Ÿ���ϴ�. �� ȸ������ ���� ǰ���� �ٸ���, �� ȸ���� ���� ������ ��ȣ�� �ִ� ����� ������ �� �ֽ��ϴ�. �� ȸ���� ���� �ִ� ���ڴ� �ش� ȸ���� ���� �� ����� �� �� �����Ǵ°��� �����ݴϴ�. Ư�� ��ǻ�Ϳ��� �ٸ� ��ǻ�ͷ� �޽����� ������ �ͽ��ϴ�. �� �� �������� ������ �ּ�ȭ�ϴ� ���α׷��� �ۼ��ϼ���.
//�Է�
//�Է��� ù �ٿ��� �׽�Ʈ ���̽��� �� C (<= 50) �� �־����ϴ�. �� �׽�Ʈ ���̽��� ù �ٿ��� ��ǻ���� �� N (<= 10000) �� ȸ���� �� M (<= 20000) �� �־����ϴ�. �� ��ǻ�ʹ� 0 ���� N-1 ������ ��ȣ�� ǥ���˴ϴ�. �� �� �ٿ� �� 3���� ������ �� ȸ���� ������ �־����ϴ�. ȸ���� ������ a b c �� ǥ���Ǹ�, �� �� �� ȸ���� a ���� b �� ��ǻ�� ���̸� ������ �� ȸ���� ���� �� ������� c �� �����˴ϴ�. c �� ������ 1 �̻��� �Ǽ��Դϴ�. ��� ȸ���� ��������� �����͸� ������ �� �ֽ��ϴ�.
//���� ��ǻ�ʹ� �׻� 0 ��, �� ��ǻ�ʹ� �׻� N-1���̶�� �����ϸ�, �̿� ���� ��δ� ������ �����Ѵٰ� �����մϴ�.
//���
//�� �׽�Ʈ ���̽�����, ����� �ּ�ȭ�Ǵ� ��ο��� ������� �� ��� �����Ǵ����� �Ҽ��� �� �� �ڸ����� ����մϴ�. 10^-7 �̻��� ���/���� ������ ���˴ϴ�.
public class Routing {
	static int T, N, E;
	static ArrayList<Edge> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[E];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));

		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//���� : 0 �� N-1


	}
	private static class Edge implements Comparable<Edge>{
		int end;
		double value;

		Edge(int end, double value) {
			this.end = end;
			this.value = value;

		}
		public int compareTo(Edge o) {
	        if(this.value > o.value)
	            return 1;
	        else if(this.value < o.value)
	            return -1;
	        return 0;
		};
		}

}
