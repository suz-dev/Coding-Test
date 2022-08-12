package d1_d2;

import java.util.Scanner;

public class 숫자배열회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();

			int N = sc.nextInt(); // 배열 크기
			int[][] arr = new int[N][N];

			// 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 90
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					sb.append(arr[j][i]);
				}
				sb.append(' ');
			}

			// 180

			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					sb.append(arr[i][j]);
				}
				sb.append(' ');
			}

			// 270
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[j][i]);
				}
				sb.append(' ');
			}

			// 출력

			String[][] str = new String[N][3];
			String[] s = sb.toString().split(" ");

			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < N; i++) {
					str[i][j] = s[cnt++];
				}
			}

			System.out.println("#" + t + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(str[i][j] + ' ');
				}
				System.out.println();
			}

		}
	}
}
