package day0920;

import java.util.Scanner;

public class 파이프옮기기1 {

	static int N;
	static int[][] arr;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		pipeEnd(1, 1, 1, 2);

		// 출력
		System.out.println(cnt);
	}

	static void pipeEnd(int sr, int sc, int er, int ec) {

		// 종료 조건
		if (er == N && ec == N) {

			cnt++;
			return;
		}

		// 실패 조건
		if (er > N || ec > N) {
			return;
		}

		// 가로
		if (sr == er && sc == ec - 1) {

			// 대각선
			if (arr[er + 1][ec] == 0 && arr[er][ec + 1] == 0 && arr[er + 1][ec + 1] == 0)
				pipeEnd(er, ec, er + 1, ec + 1);

			// 가로
			if (arr[er][ec + 1] == 0)
				pipeEnd(er, ec, er, ec + 1);

		}

		// 세로
		if (sr == er - 1 && sc == ec) {

			// 대각선
			if (arr[er + 1][ec] == 0 && arr[er][ec + 1] == 0 && arr[er + 1][ec + 1] == 0)
				pipeEnd(er, ec, er + 1, ec + 1);

			// 세로
			if (arr[er + 1][ec] == 0)
				pipeEnd(er, ec, er + 1, ec);

		}

		// 대각선
		if (sr == er - 1 && sc == ec - 1) {

			// 대각선
			if (arr[er + 1][ec] == 0 && arr[er][ec + 1] == 0 && arr[er + 1][ec + 1] == 0)
				pipeEnd(er, ec, er + 1, ec + 1);

			// 세로
			if (arr[er + 1][ec] == 0)
				pipeEnd(er, ec, er + 1, ec);

			// 가로
			if (arr[er][ec + 1] == 0)
				pipeEnd(er, ec, er, ec + 1);

		}
	}
}