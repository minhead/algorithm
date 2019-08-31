package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pb3584 {

	static int N;
	static int par[][];
	static ArrayList<Integer>[] list;
	static int depth[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		N = Integer.parseInt(br.readLine());
//		StringTokenizer st;
		int tmp;
		int dep=0;
		for(tmp = 1; tmp<=10000; tmp*=2) {
			dep++;
		}
//		for(int i =1;i<N;i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//		}
		System.out.println(tmp);
		System.out.println(dep);
		double tdd = Math.pow(2, 17);
		System.out.println(tdd);
		

	}

}
