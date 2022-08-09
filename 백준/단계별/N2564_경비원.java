package 단계별;

import java.util.Scanner;

public class N2564_경비원 {

	// 일자로 펴는게 관건
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();

		int k = sc.nextInt();
		int[] point = new int[k];

		int police = 0;
		for (int i = 0; i < k + 1; i++) {
			int dir = sc.nextInt();
			int pos = sc.nextInt();

			int tmp = 0;

			switch (dir) {
			case 1:
				tmp = pos;
				break;
			case 2:
				tmp = w + h + (w - pos);
				break;
			case 3:
				tmp = w + h + w + (h - pos);
				break;
			case 4:
				tmp = w + pos;
				break;
			}

			if (i < k) {
				point[i] = tmp;
			} else {
				police = tmp;
			}
		}

		int sum = 0;
		for (int i = 0; i < k; i++) {
			int a = Math.abs(police - point[i]);
			int b = 2 * (w + h) - a;

			sum += Math.min(a, b);
		}

		System.out.println(sum);
	}
}
