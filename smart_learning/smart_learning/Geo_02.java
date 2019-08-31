//점의 위치
//2차원 평면에 N개의 점으로 이루어진 다각형이 주어진다
//그리고 두 개의 점 P1,P2가 주어지는데
//점P1,P2가 다각형의 내부에 있는지 외부에 있는지 판별하는 문제
//단, 점 P1,P2는 주어진 다각형의 선분 위에 존재하지 않는다
//한 쪽끝이 점 P인 반직선과 교차하는 선분의 개수를 센다
//교차하는 선분의 개수가 홀수면 P는 다각형 안에 있고, 짝수라면 P는 다각형 외부에 있다
//예외처리 4가지 
//반직선이 정점을 지나는 경우
//반직선이 선분을 지나는 경우
//반직선이 선분과 겹치게 지나는 경우
//예외가 안생기게 반직선을 그리면 됨
// 한쪽 끝이 P인 반직선을 다각형 밖에 있는 것이 확실한 점 Q를 잡아 선분 PQ라 생각할 수 있음
// 정점과 선분을 지나지 않는 반직선(선분 PQ) 만들기
// 주어지는 다각형의 점들은 정수 좌표
// Q의 좌표를 (10^9 +1, Py+1)이라 하자
// 점Q는 다각형 밖에 있는 것이 확실하다(입력가능한 좌표 범위 밖이다)
// 선분 PQ는 점 P,Q를 제외하고 사이에 정수 좌표를 가지는 점을 지나지 않는다
// 즉 다각형이 어떻게 주어지든 절대 다각형의 정점과 선분을 지나지 않는다
//ccw= (bx-ax)(cy-ay)-(cx-ax)(by-ay)
//선분교차판별 -> ab와 cd가 교차한다 = ccw(a,b,c)*ccw(a,b,d) = -1 && ccw(c,d,a)*ccw(c,d,b)=-1
package smart_learning;

public class Geo_02 {

	static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {
		long k = (long) (bx - ax) * (cy - ay) - (long) (cx - ax) * (by - ay);
		if (k > 0)
			return 1;
		if (k < 0)
			return -1;
		return 0;
	}

	static boolean is_cross(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
		if (ccw(ax, ay, bx, by, cx, cy) * ccw(ax, ay, bx, by, dx, dy) < 0
				&& ccw(cx, cy, dx, dy, ax, ay) * ccw(cx, cy, dx, dy, bx, by) < 0) {
			return true;
		}
		return false;
	}
	static boolean check(int x1, int y1) {//x1->P좌표 x2->Q좌표
		int x2 = (int)1e9+1;
		int y2 = y1+1;
		int ret = 0;
		for(int i=1; i<=N;i++) {
			int j = i%N+1;
			if(is_cross(x1,y1,x2,y2,X[i],Y[i],X[j],Y[j])) //ij선과 pq선이 교차하는지 화긴
				ret++;
		}
		if(ret%2==1) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
