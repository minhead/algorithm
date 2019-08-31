// 2차원 평면 위에 N개의 점으로 이루어진 단순 다각형 주어짐, 다각형 면적 구하라
// a,b 외적 : a길이 *b길이*sin세타 = 외적
// a,b 외적 = ax*by -bx*ay 
// a,b 외적 *1/2 = 삼각형넓이

package smart_learning;

public class Geo_01 {
	static int X[],Y[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans = 0;
		int N = 5;
		X = new int[N+1];
		Y = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			int j = i % N + 1;
			ans = ans+(long)X[i]*Y[j]-(long)X[j]*Y[i];
		}
		ans = Math.abs(ans);
		System.out.println(ans/2);
		

	}

}
