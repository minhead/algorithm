package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//�˰��� �����ذ�����
//���� ī�޶� ��ġ p865
//�ּ��������� �˰������� Ǯ����
public class DominatingSet {

	static int G, H; // g:���������� h:�����������ϴ� ������ ��
	static ArrayList<Integer>[] list;// �������� ����Ǵ� ��������Ʈ
	static int[] discovered;
	static int count, installed; // installed : ���ݱ��� ��ġ�� ī�޶��� �� ��
	static final int UNWATCHED = 0;
	static final int WATCHED = 1;
	static final int INSTALLED = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			list = new ArrayList[G];
			discovered = new int[G];

			for (int i = 0; i < G; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			count = 1;
			dfsAll();
			System.out.println(installed);
		}
	}

	// �׷����� �����ϴµ� �ʿ��� ī�޶��� �ּ� ���� �����
	static void dfsAll() {
		installed = 0;
		for (int i = 0; i < G; i++) {
			if (discovered[i] == 0&& dfs(i)==UNWATCHED) {
				++installed;

			}
		}
	}

	// here�κ��� ���̿켱 Ž�� �ϰ� here�� ������ ��ȯ�Ѵ�
	static int dfs(int here) {
		discovered[here] = count++;
		int[] children = { 0, 0, 0 };

		for (int i = 0; i < list[here].size(); i++) {
			int there = list[here].get(i);
			if(discovered[there]==0) {//here���� ������ ����� there ��尡 �湮���� ������
				++children[dfs(there)];// there ��� 
				//�湮�ϰ� there����� ������ children�� �ִ´�
			}
		}
		//�ڼ� ��� �� ���õ����ʴ� ��尡 ���� ��� ī�޶� ��ġ�Ѵ�
		if(children[UNWATCHED]>0) {
			++installed;
			return INSTALLED;
		}
		//�ڼ� ��� �� ī�޶� ��ġ�� ��尡 ���� ��� ��ġ�ʿ� ����
		if(children[INSTALLED]>0) {
			return WATCHED;
		}
		return UNWATCHED;
	}

}
