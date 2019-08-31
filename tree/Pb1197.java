package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Pb1197 {

	static int par[];
	static Node[] nodelist;	
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		par = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			par[i] = i;
		}
		nodelist = new Node[E];
		list = new ArrayList<>();
		int answer = 0;
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodelist[i]= new Node(a, b, c);
			list.add(new Node(a, b, c));

		}
		Arrays.sort(nodelist, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.value-o2.value;
			}
		});
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.value-o2.value;
			}
		});;
//		for(int i=0;i<E;i++) {
//			int X = find(nodelist[i].from);
//			int Y = find(nodelist[i].to);
//			if(X==Y) {
//				continue;
//			}else {
//				par[X] = Y;
//				answer = answer+nodelist[i].value;
//			}
//		}
		for(int i=0;i<E;i++) {
			int X = find(list.get(i).from);
			int Y = find(list.get(i).to);
			if(X==Y) {
				continue;
			}else {
				par[X] = Y;
				answer = answer+list.get(i).value;
			}
		}
		System.out.println(answer);

	}

	static int find(int a) {
		if (a == par[a])
			return a;
		else
			par[a] = find(par[a]);
		return par[a];
	}

	static class Node {
		int from;
		int to;
		int value;

		private Node(int from, int to, int value) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
			this.value = value;
		}
	}
}