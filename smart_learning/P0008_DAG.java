package smart_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P0008_DAG {

	static int N,M,a,b,c;
	static ArrayList<Integer>[] con, from,fromv;
	static int in[];
	static int D[];
	static ArrayList<Integer> order;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int test_case = 1; test_case<=T;test_case++) {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		in = new int[N+1];
		con = new ArrayList[N+1];
		for(int i = 0; i<M;i++) { //M개의 간선에 대해 수행
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // 값을 입력받는다
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			con[a].add(b); //인접리스트 수행 a->b 로 가는 간선, b indegree
			in[b]++;
			from[b].add(a);//b로들어오는 뒤집힌 간선
			fromv[b].add(c);//b로들어오는거의 가중치
			
		}
		D = new int[N+1]; //빨간색을 넣는 D 배열생성
		for(int i = 1; i<=N; i++) {
			if(i==1|| in[i]>0) //i로 들어오는 간선이 있으면
				D[i] = 0; //0초기화
			else 
				D[i]=(int)2e9; //무한값으로 초기화
		}
		//위상정렬 시작
		order = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++){ //i로 들어오는 간선이 없으면 queue에 i추가
			if(in[i]==0)
				queue.add(i);
		}
		while(!queue.isEmpty()) { //queue 를 돈다
			int q = queue.poll(); //queue에서 하나 뽑아서
			order.add(q);
			for(int t: con[q]) { //queue에 연결된 t에대해서 간선 뺄때 indegree만 감소시켜줌
				if(--in[t]==0) // indegree 감소시킨 값이 0이면
					queue.add(t); // queue에 추가
			}
		}
		//위상정렬 끝
		//order에는 위상정렬 순서대로 저장되어있음
		for(int n:order) {
			for(int i=0; i<from[n].size();i++) {
				int t = from[n].get(i);
				int v = fromv[n].get(i);
				D[n]= Math.max(D[n], D[t]+v);
			}
			D[n] = Math.min(D[n], (int)2e9);
		}

		System.out.println("#"+test_case+ " "+D[N]);
		
	}
	}
}
