package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���ǰ���'
//���簢������ �̷���� �ִ� ���� �ٴ� ������ �־�����. ���� ������ ���� ���α׷��� �ۼ��Ͻÿ�.
//�� ���簢���� ����, ���� �Ǵ� �밢������ ����Ǿ� �ִ� �簢���� �ɾ �� �ִ� �簢���̴�. 
//�� ���簢���� ���� ���� ��������, �� ���簢������ �ٸ� ���簢������ �ɾ �� �� �ִ� ��ΰ� �־�� �Ѵ�. ������ �ٴٷ� �ѷ��׿� ������, ���� ������ ���� �� ����.
//
//�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� �׽�Ʈ ���̽��� ù° �ٿ��� ������ �ʺ� w�� ���� h�� �־�����. w�� h�� 50���� �۰ų� ���� ���� �����̴�.
//��° �ٺ��� h�� �ٿ��� ������ �־�����. 1�� ��, 0�� �ٴ��̴�.
//�Է��� ������ �ٿ��� 0�� �� �� �־�����.
//
//�� �׽�Ʈ ���̽��� ���ؼ�, ���� ������ ����Ѵ�.
public class Pb4963 {

	static int w, h;
	static int map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		if (w == 0 && h == 0) {
			return;
		} else {
			map = new int[h+1][w+1];
			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}

		}
	}

}
