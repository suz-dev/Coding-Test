package d3_d4;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc 개수
		for (int t = 1; t <= T; t++) {
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
			int N = sc.nextInt();

			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				int type = sc.nextInt();

				switch (type) {
				case 1:
					int value = sc.nextInt();
					q.add(value);
					break;
				case 2:
					int output;
					if (q.isEmpty())
						output = -1;
					else
						output = q.poll();
					System.out.print(output + " ");
					break;
				}
			}
			System.out.println();
		}
	}
}