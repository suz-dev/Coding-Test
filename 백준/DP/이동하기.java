package DP;

import java.util.Scanner;

public class 이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// 가로, 세로, 오른쪽 대각선 아래로만 이동 가능
		// 현재 위치로 올 수 있는 방향
		// 세로 위, 왼쪽 대각선 위, 왼쪽 (최대값 비교)

		int[][] dp = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				dp[r][c] = sc.nextInt();
				int max = Math.max(dp[r - 1][c], Math.max(dp[r][c - 1], dp[r - 1][c - 1]));
				dp[r][c] += max;
			}
		}

		System.out.println(dp[N][M]);
	}
}