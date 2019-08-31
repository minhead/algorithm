package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pb9372 {

	class Edge{
		int a;
		int b;
		public Edge(int a,int b) {
			// TODO Auto-generated constructor stub
			this.a = a;
			this.b = b;
		}
	}
	
	static int N,M;
	static ArrayList[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int test_case = 1; test_case <=T ;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list =new ArrayList[N+1];
			for(int i = 1; i<=N;i++) {
				list[i]= new ArrayList<>();
			}
			for(int i = 1;i<=M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
		}
		

	}

}
