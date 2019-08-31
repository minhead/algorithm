package data_structure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {

	static class Temp {
		int x;
		int y;
	}

	static PriorityQueue<Temp> q = new PriorityQueue<Temp>(10, new Comparator<Temp>() {

		@Override
		public int compare(Temp T1, Temp T2) {
			// TODO Auto-generated method stub
			if (T1.x != T2.x) // x축에 대하여 정렬 x 같으면 y에 대해 정렬
				return T1.x - T2.x;
			return T1.y - T2.y;
		}
	});

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temp t[] = new Temp[5];
		for (int i = 0; i < 5; i++) {
			t[i] = new Temp();
			t[i].x = (int)(Math.random() *5);
			t[i].y = (int)(Math.random() *5);
			System.out.print(t[i].x+" "+t[i].y);
			q.offer(t[i]);
		}
		
		System.out.println();
		while(!q.isEmpty()) {
			Temp temp = q.poll();
			System.out.println(temp.x+" "+temp.y);
		}

	}

}
