package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//알고스팟 문제 (https://algospot.com/judge/problem/read/ROUTING)
//위 그림은 여러 개의 컴퓨터들과 각 컴퓨터들을 잇는 회선을 나타냅니다. 각 회선들은 각각 품질이 다르며, 각 회선을 지날 때마다 신호에 있던 노이즈가 증폭될 수 있습니다. 각 회선에 쓰여 있는 글자는 해당 회선을 지날 때 노이즈가 몇 배 증폭되는가를 보여줍니다. 특정 컴퓨터에서 다른 컴퓨터로 메시지를 보내고 싶습니다. 이 때 노이즈의 증폭을 최소화하는 프로그램을 작성하세요.
//입력
//입력의 첫 줄에는 테스트 케이스의 수 C (<= 50) 이 주어집니다. 각 테스트 케이스의 첫 줄에는 컴퓨터의 수 N (<= 10000) 과 회선의 수 M (<= 20000) 이 주어집니다. 각 컴퓨터는 0 부터 N-1 까지의 번호로 표현됩니다. 그 후 줄에 각 3개의 정수로 각 회선의 정보가 주어집니다. 회선의 정보는 a b c 로 표현되며, 이 때 이 회선은 a 번과 b 번 컴퓨터 사이를 이으며 이 회선을 지날 때 노이즈는 c 배 증폭됩니다. c 는 언제나 1 이상의 실수입니다. 모든 회선은 양방향으로 데이터를 전송할 수 있습니다.
//시작 컴퓨터는 항상 0 번, 끝 컴퓨터는 항상 N-1번이라고 가정하며, 이와 같은 경로는 언제나 존재한다고 가정합니다.
//출력
//각 테스트 케이스마다, 노이즈가 최소화되는 경로에서 노이즈는 몇 배로 증폭되는지를 소숫점 밑 열 자리까지 출력합니다. 10^-7 이상의 상대/절대 오차가 허용됩니다.
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
		//시작 : 0 끝 N-1


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
