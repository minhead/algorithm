package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Edge{
	int end;
	int value;
	
	Edge(int end,int value){
		this.end = end;
		this.value = value;
	}
}

public class Baek1753 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int vertex = Integer.parseInt(str[0]);
		int edge = Integer.parseInt(str[1]);
		int K = Integer.parseInt(br.readLine());
		int[] distance = new int[vertex+1];
		
		boolean[] visited = new boolean[vertex+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		ArrayList<Edge>[] list =  new ArrayList [vertex +1];
		for(int i = 0; i<= vertex; i++) {
			list[i] = new ArrayList<Edge>();
			
		}
		
		for(int i =0; i< edge; i++) {
			str = br.readLine().split(" ");
			list[Integer.parseInt(str[0])].add(new Edge(Integer.parseInt(str[1]),Integer.parseInt(str[2])));
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(K);
		distance[K] = 0;
		while(!q.isEmpty()) {
			int current = q.poll();
			visited[current] = true;
			
			for(int i =0; i<list[current].size();i++){
				int next = list[current].get(i).end;
				int value = list[current].get(i).value;
				
				if(distance[next]>distance[current]+value) {
					distance[next]= Math.min(distance[next], value+distance[current]);
					q.add(next);
				}
			}
		}
	}

}
