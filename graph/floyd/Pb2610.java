package floyd;
// 회의준비

//위원회에서 모든 참석자들의 의사전달시간 중 최댓값이 최소가 되도록 대표를 정하는 프로그램을 작성하시오.
//입력
//첫째 중에 회의에 참석하는 사람의 수 N이 주어진다.
// 참석자들은 1부터 N까지의 자연수로 표현되며 회의에 참석하는 인원은 100 이하이다. 
// 둘째 줄에는 서로 알고 있는 관계의 수 M이 주어진다. 
// 이어 M개의 각 줄에는 서로 아는 사이인 참석자를 나타내는 두개의 자연수가 주어진다.
//출력
//첫째 줄에는 구성되는 위원회의 수 K를 출력한다. 
//다음 K줄에는 각 위원회의 대표 번호를 작은 수부터 차례로 한 줄에 하나씩 출력한다. 
//한 위원회의 대표가 될 수 있는 사람이 둘 이상일 경우 그중 한 명만 출력하면 된다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Pb2610 {
	// 무한대 상수
	private static final int INFINITE = 101;

	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 가중치 저장 배열 초기화
		int[][] matrix = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					matrix[i][j] = INFINITE;
				}
			}
		}

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			matrix[i][j] = matrix[j][i] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘을 통해 최소 가중치로 변경
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}
		}

		// 그룹 저장 배열 리스트 배열 초기화
		ArrayList<Integer>[] groups = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			groups[i] = new ArrayList<>();
		}

		// 방문 여부 저장 배열 초기화
		boolean[] isVisited = new boolean[N + 1];

		// 루프를 돌며 각 그룹에 해당하는 사람들을 분류하여 그룹 저장 배열 리스트 배열에 추가
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (matrix[i][j] != INFINITE && !isVisited[j]) {
					isVisited[j] = true;
					groups[i].add(j);
				}
			}
		}

		// 그룹 갯수 저장 변수 초기화
		int K = 0;

		// 대표자 인덱스 저장 배열 리스트 초기화
		ArrayList<Integer> groupLeaderIdxs = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			// 해당 그룹에 사람이 1명이라도 있을 경우에만
			if (groups[i].size() != 0) {
				// 그룹 갯수 1 증가
				K++;

				// 가장 멀리 떨어져있는 사람과의 가중치가 가장 작은 값, 그 인덱스를 저장하는 변수 초기화
				int min = Integer.MAX_VALUE;
				int minIdx = 0;

				// 그룹내 한 사람을 기준으로 가장 멀리 떨어져있는 사람과의 가중치를 구함
				for (int start : groups[i]) {
					int max = Integer.MIN_VALUE;

					for (int end : groups[i]) {
						max = Math.max(max, matrix[start][end]);
					}

					// 가중치가 더 작은 경우를 발견하면 값을 변경
					if (max < min) {
						min = max;
						minIdx = start;
					}
				}

				// 해당 그룹의 대표자 인덱스 저장 배열에 찾은 대표자의 인덱스를 추가
				groupLeaderIdxs.add(minIdx);
			}
		}

		// 대표자 인덱스 저장 배열 오름차순으로 정렬
		Collections.sort(groupLeaderIdxs);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(K).append(NEW_LINE);

		for (int groupLeaderIdx : groupLeaderIdxs) {
			sb.append(groupLeaderIdx).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}
