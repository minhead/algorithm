package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//알고리즘 문제해결전략
//감시 카메라 설치 p865
//최소지배집합 알고리즘으로 풀이함
public class DominatingSet {

	static int G, H; // g:갤러리개수 h:갤러리연결하는 복도의 수
	static ArrayList<Integer>[] list;// 갤러리에 연결되는 인접리스트
	static int[] discovered;
	static int count, installed; // installed : 지금까지 설치한 카메라의 총 수
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

	// 그래프를 감시하는데 필요한 카메라의 최소 수를 계산함
	static void dfsAll() {
		installed = 0;
		for (int i = 0; i < G; i++) {
			if (discovered[i] == 0&& dfs(i)==UNWATCHED) {
				++installed;

			}
		}
	}

	// here로부터 깊이우선 탐색 하고 here의 정보를 반환한다
	static int dfs(int here) {
		discovered[here] = count++;
		int[] children = { 0, 0, 0 };

		for (int i = 0; i < list[here].size(); i++) {
			int there = list[here].get(i);
			if(discovered[there]==0) {//here노드와 인접한 노드중 there 노드가 방문한적 없으면
				++children[dfs(there)];// there 노드 
				//방문하고 there노드의 정보를 children에 넣는다
			}
		}
		//자손 노드 중 감시되지않는 노드가 있을 경우 카메라 설치한다
		if(children[UNWATCHED]>0) {
			++installed;
			return INSTALLED;
		}
		//자손 노드 중 카메라가 설치된 노드가 있을 경우 설치필요 없음
		if(children[INSTALLED]>0) {
			return WATCHED;
		}
		return UNWATCHED;
	}

}
