package data_structure;
//구간 최소값 문제
//N개의 데이터가 주어졌을 때, Q 개의 쿼리를 수행하는 코드를 작성하라
//쿼리는 3개의 정수 c,x,y로 이루어져있으며 각각의 쿼리는 c가 0인 경우
//X~Y 구간의 최소값을 출력하고 C가 1인경우 X번째 데이터를 Y로 수정한다

import java.util.Scanner;

public class Tree03_Index {
	static final int MAX_TREE = 262144, MAX_N = 100001;
	static int N,Q;
	static int tree[] = new int [MAX_TREE];
	static int data[] = new int [MAX_N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //데이터 수
		Q = sc.nextInt(); //쿼리수
		for(int i=0;i<N;i++) {
			data[i] = sc.nextInt();
		}
		//처음으로 N보다 크거나 같은 2의 제곱수
		int tmpN;
		int h=0;
		for(tmpN =1; tmpN<=N;tmpN*=2) {
			h++;
			//1-2-4-8-16 ... 진행하면서 N보다 큰 2의제곱수를 구해서 tmpN에 넣는다 트리 높이는 h
		}
		for(int i=0;i<N;i++) {
			tree[i+tmpN]=data[i];//리프노드를 집어넣기 
		}
		for(int i=tmpN-1;i>1;i--) {//밑에서부터 트리를 올라가면서 최소값을 집어넣는다
			tree[i] = Math.min(tree[i*2],tree[i*2+1]); //왼쪽, 오른쪽 노드중 최소값을 tree[i]에 넣는다
		}
		//쿼리 입력 및 처리
		for(int i = 1; i<=Q; i++) {
			int c,x,y;
			c = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			//수정
			if(c==1) { //x번째 데이터를 Y로 수정한다
				tree[x+tmpN-1]=y;
				x = (x+tmpN-1)/2; //X의 부모노드로 이동하면서 최소값을 갱신해준다
				while(x!=0) {
					tree[x] = Math.min(tree[x*2], tree[x*2+1]);
					x/=2;
				}
			}
			//구간합 구하기
			if(c==0) {
				int min = 2000000000;
				x = x+tmpN-1;
				y = y+tmpN-1;
				while(x<=y) {
					if(x%2==1)
						min =  Math.min(tree[x], min);
					if(y%2==0)
						min =  Math.min(tree[y], min);
					x = (x+1)/2;
					y = (y-1)/2;
				}
				System.out.println(min);
			}
		}
	}

}
