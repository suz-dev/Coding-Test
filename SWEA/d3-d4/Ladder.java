package d3_d4;

import java.util.Scanner;

public class Ladder {

	static int[][] ladder = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // 순서

			// 사다리 배열 채우기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}

			int[] dr = { -1, 1 };
			int start = -1;

			// 끝에서 시작
			for (int c = 0; c < 100; c++) {
				if (ladder[99][c] == 2) {
					start = c; // 열
				}
			}

			for (int r = 99; r >= 0; r--) {

				for (int d = 0; d < 2; d++) {
					// 좌우 탐색
					if (start + dr[d] >= 0 && start + dr[d] < 100 && ladder[r][start + dr[d]] == 1) {

						while (start + dr[d] >= 0 && start + dr[d] < 100 && ladder[r][start + dr[d]] == 1) {
							start += dr[d];
						}
						break;
					}
				}
			}
			System.out.println("#" + t + " " + start);
		}
	}
}
