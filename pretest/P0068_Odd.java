package pretest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//홀수짝수경로
//N개의 정점이 있는 무방향 그래프를 생각해보자. 
//간선의 가중치는 모두 1이라고 한다. 정점들은 1번부터 N번까지 번호가 붙어 있다. 
//본 문제에서는 시작 정점을 1번 정점으로 정한다.
//
//최단경로 문제는 시작 정점에서 모든 정점 각각으로 가는 가장 짧은 경로를 찾는 문제이다.
//특정한 정점 X 하나에 대해서 이 문제를 자세히 생각해 보자.(다른 정점들에 대해서도 똑같은 생각을 해 보는 것이다.)
//1번 정점에서 시작해서 X에서 끝나는 (동일한 정점을 여러번 지나든, 동일한 간선을 여러번 사용하든, 길이가 얼마이든 
//상관하지 않고) 모든 가능한 경로들을 다 나열한 집합을 All-Path(1,X)라고 하자.
//시작 정점 1번에서 X로 가는 최단 경로는 당연히 All-Path(1,X) 중에서 가장 길이가 짧은 것이다. 
//여기서 길이는 경로에 포함된 간선의 개수로 정의한다.(간선의 가중치가 모두 1이므로)
//
//유명한 Dijkstra 알고리즘은 이러한 가장 짧은 경로를 모든 X에  대해서 다 찾는다.
//물론 Dijkstra 알고리즘이 All-Path(1,X)에 속한 모든 경로를 다 검사하는 것은 아니지만, 
//그렇게 하지 않고도 가장 짧은 경로를 찾을 수 있다는 것이 알고리즘이 우수하다는 것을 말해준다.
//
//All-Path(1,X)보다 좀 작은 집합을 생각해 보자. 
//1번 정점에서 X번 정점으로 가는 경로에 A1, A2, ... Ak가 있다고 하자.
//단, K>=1, A1=1, Ak=X이다. 이경로에 속하는 연속된 두 정점 Ai, Ai+1에 대해서 Ai+1에서 X로 가는
//최단경로가 Ai에서 X로 가는 최단 경로보다 더 길지 않아야 한다는 조건을 추가하였을때, 이 추가된
//조건까지 만족하는 경로들만 모은 집합을 All-Path-No-Farther(1,X)라고 하자. 이때 모든 정멈에 대하여
//All-Path-No-Father(1,X)에서 길이가 홀수인 경로와 길이가 짝수인 경로가 존재하는지의 여부를 구하는 프로그램을
//작성하라.
public class P0068_Odd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int test_case = 1; test_case <=T; test_case++) {
			
		}

	}

}
