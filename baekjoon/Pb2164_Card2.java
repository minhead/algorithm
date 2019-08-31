package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Pb2164_Card2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		sc.close();
//		int N = 6;
		Queue<Integer> q = new LinkedList();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		while(q.size()>0) {
			if(q.size()==1)
				break;
			q.poll();
			if(q.size()==1)
				break;
			int g = q.poll();
			q.add(g);

		}
		System.out.println(q.poll());	
		
	}

}
