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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Pb2610 {

	static int N,M;
	static int d[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		d = new int[N+1][N+1];
		for(int i = 1; i<=M;i++) {
			
		}
		
			
		
		

	}

}
