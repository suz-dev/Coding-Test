package d1_d2;

import java.util.Scanner;

public class 파리퇴치 {

	public static int[][] arr;

	public static int sum;
	public static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc 개수
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 배열 크기
			int M = sc.nextInt(); // 스프레이 세기 (+,x 방향 분사)

			arr = new int[N][N];

			// 배열 채우기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					// 1. 십자 방향
					int[] dxPlus = { -1, 1, 0, 0 };
					int[] dyPlus = { 0, 0, -1, 1 };

					check(dxPlus, dyPlus, r, c, N, M);

					// 2. X자 방향
					int[] dxX = { -1, -1, 1, 1 };
					int[] dyX = { -1, 1, -1, 1 };

					check(dxX, dyX, r, c, N, M);
				}
			}

			System.out.println("#" + t + " " + max);

			// 초기화
			max = 0;

		}
	}

	// 4방향 탐색
	public static void check(int[] a, int[] b, int r, int c, int N, int M) {

		sum = arr[r][c]; // 시작
		for (int d = 0; d < 4; d++) {
			// M만큼씩 탐색
			for (int m = 1; m < M; m++) {

				int cx = r + (a[d] * m);
				int cy = c + (b[d] * m);

				if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
					sum += arr[cx][cy];
				}
			}
		}
		max = Math.max(max, sum);
	}

}