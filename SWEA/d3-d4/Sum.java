package d3_d4;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int[][] arr = new int[100][100];
			int N = sc.nextInt(); // tc 번호

			int sum = 0;
			int max = 0;

			// 배열 채우기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 행의 합
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				max = Math.max(max, sum);
				sum = 0;
			}

			// 열의 합
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				max = Math.max(max, sum);
				sum = 0;
			}

			// 대각선의 합
			for (int i = 0; i < 100; i++) {

				// 정방향
				for (int j = 0; j < 100; j++) {
					if (i == j)
						sum += arr[i][j];
				}
				max = Math.max(max, sum);
				sum = 0;

				// 역방향
				for (int j = 99; j >= 0; j--) {
					if (i == 99 - j) {
						sum += arr[i][j];
					}
				}
				max = Math.max(max, sum);
				sum = 0;
			}

			System.out.println("#" + N + " " + max);

		}
	}

}
