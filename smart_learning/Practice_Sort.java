package smart_learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Hull {
	int x;
	int y;

	Hull(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Practice_Sort {

	static int N;
	static Hull list[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 5;
		list = new Hull[N + 1];
		list[1] = new Hull(1, 2);
		list[2] = new Hull(5, 1);
		list[3] = new Hull(11, 4);
		list[4] = new Hull(0, 9);
		list[5] = new Hull(3, 7);

//		for (int i = 1; i <= N; i++) {
//			if (list[1].y > list[i].y || list[1].y == list[i].y && list[1].x > list[i].x) {
//				Hull temp = list[1];
//				list[1] = list[i];
//				list[i] = temp;
//			}
//		}
		for(int i=1; i<=N;i++) {
			System.out.println(list[i].x+", "+list[i].y);
		}

		Arrays.sort(list, 1, N+1 , new Comparator<Hull>() {

			@Override
			public int compare(Hull a, Hull b) {
				// TODO Auto-generated method stub
//				int v = ccw(new Hull(list[1].x, list[1].y), a, b);
//				if (v > 0)
//					return -1;
//				if (v < 0)
//					return 1;
//				return (Math.abs(a.x) + a.y) - (Math.abs(b.x) + b.y);

				return a.x-b.x;

			}
		});

		for(int i=1; i<=N;i++) {
			System.out.println(list[i].x+", "+list[i].y);
		}

	}

	static int ccw(Hull A, Hull B, Hull C) {
		long cal = 0;
		cal = (long) (B.x - A.x) * (C.y - A.y) - (long) (C.x - A.x) * (B.y - A.y);
		if (cal > 0)
			return 1;
		else if (cal < 0)
			return -1;
		else
			return 0;
	}
}
