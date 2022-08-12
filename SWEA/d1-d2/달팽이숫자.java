package d1_d2;

import java.util.Scanner;

public class 달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			int cnt = 1; // 시작 값

			int r = 0;
			int c = 0;

			// 우하좌상 탐색
			int drc = 1;
			while (cnt <= N * N) {

				arr[r][c] = cnt++;

				switch (drc) {
				case 1:
					if (c == N - 1 || arr[r][c + 1] != 0) {
						drc = 2;
						r++;
					} else {
						c++;
					}
					break;
				case 2:
					if (r == N - 1 || arr[r + 1][c] != 0) {
						drc = 3;
						c--;
					} else {
						r++;
					}
					break;
				case 3:
					if (c == 0 || arr[r][c - 1] != 0) {
						drc = 4;
						r--;
					} else {
						c--;
					}
					break;
				case 4:
					if (r == 0 || arr[r - 1][c] != 0) {
						drc = 1;
						c++;
					} else {
						r--;
					}
					break;

				}
			}

			System.out.println("#" + t + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}