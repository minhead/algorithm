package data_structure;

public class Tree02_Full_Binary {
	static int n;
	static int tree[];
	
	static void inorder(int node) {
		if(node*2<=n) { //왼쪽 자식노드 탐색
			inorder(node*2);
		}
		System.out.println(tree[node]); //본인노드 탐색
		if(node*2+1<=n) { // 오른쪽 자식노드 탐색
			inorder(node*2+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n = 6;
		tree = new int[n+1];
		for(int i = 1; i<=n;i++)
		tree[i] = i;
		
		inorder(1);
//		sc.close();
		

	}

}
