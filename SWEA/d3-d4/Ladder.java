package d3_d4;

import java.util.Scanner;

public class Ladder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // tc 번호

			int[][] ladder = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}

			for (int i = 99; i >= 0; i++) {
				for (int j = 0; j < 100; j++) {

					int[] drc = { -1, 1 }; // 왼, 오 탐색

					// 시작점
					if (ladder[i][j] == 2) {

						while (j + drc[0] >= 0 && j + drc[1] < 100) {
							if (ladder[i][j + drc[0]] == 1) {
								j += drc[0];
								break;
							} else if (ladder[i][j + drc[1]] == 1) {
								j += drc[1];
								break;
							}
						}
					}
				}
			}

		}
	}
}
