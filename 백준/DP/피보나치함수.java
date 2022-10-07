package DP;

import java.util.Scanner;

public class 피보나치함수 {

	static int N;
	static int[][] dp = new int[41][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();

			dp[0][0] = 1;
			dp[1][1] = 1;

			int k = 2;
			while (k <= N) {
				dp[k][0] = dp[k - 1][0] + dp[k - 2][0];
				dp[k][1] = dp[k - 1][1] + dp[k - 2][1];
				k++;
			}

			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}