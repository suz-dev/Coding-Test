package d3_d4;

import java.util.Scanner;

public class 오목판정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			char[][] board = new char[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			int[] dx = { 1, 0, 1, -1, };
			int[] dy = { 0, -1, -1, -1, };

			boolean check = false;
			out: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (board[i][j] == 'o') {
						int cnt = 1;

						for (int d = 0; d < 4; d++) {
							for (int k = 1; k < 5; k++) {
								int cx = i + dx[d] * k;
								int cy = j + dy[d] * k;

								if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
									if (board[cx][cy] == 'o')
										cnt++;
									else
										break;
								}
							}

							if (cnt >= 5) {
								check = true;
								break out;
							}
							cnt = 1;

						}
					}
				}
			}
			System.out.print("#" + t + " ");
			if (check)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}