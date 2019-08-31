//이차원 평면상에 위치한 많은 점들이 있다. 두 점 P(x1,y1) Q(x2,y2)의 사이의 거리는 SQRT[(x1-x2)^2 + (y1-y2)^2]로 정의한다면,
//모든 점들 사이에서, 가장 가까운 거리를 찾아내시오.
//제약조건
//각 문제에 대해 답을 찾아내는 시간은 0.5초(500ms 이내)일 것
//입력
//입력문제는 텍스트파일로 주어지고, 파일내 형식은 다음과 같음
// - 첫번 째 행에, 전체 문제 갯수가 나오고
// - 두번째 행부터 다음과 같은 형식
//   . 점의 수가 나오고
//   . 그 다음 줄에 공백으로 구분되어 x,y값이 나옴

package smart_learning;

import java.util.Arrays;
import java.util.Comparator;

static class Point{
	int idx;
	int x,y;
	public Point(int idx,int x,int y) {
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
	public double dist(Point b) {
		return Math.sqrt(Math.pow((x-b.x),2) +Math.pow(y-b.y, 2));
	}
}

public class Geo_ClosestDistance {

	//1. 이차원 배열을 Point 객체 배열로 전환
	//2. xPoints를 x축 기준으로 소팅
	//3. 재귀적으로 호출하면서 최소사이거리를 계산할 closest()메서드 호출
	private static double closestDistance(int[][] p) {
		if(p == null) {
			return -1;
		}
		int n = p.length;
		if(n==1)
			return -1;
		// 1.이차원 배열을 Point 객체 배열로 전환
		Point[] points = new Point[n];
		for(int i=0;i<n;i++) {
			points[i] = new Point(i,p[i][0],p[i][1]); //index,x좌표,y좌표
		}
		
		//2. x축 기준으로 정렬
		Point[] xPoints = new Point[n];
		System.arraycopy(points, 0, xPoints, 0, n);
		Arrays.sort(xPoints, new Comparator<Point>() {
			
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
