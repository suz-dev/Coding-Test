package d3_d4;

import java.util.Scanner;

public class 회문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			char[][] arr = new char[8][8]; // 글자판
			int N = sc.nextInt(); // 회문 길이

			// 배열 채우기
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int cnt = 0; // 회문 개수
			for (int k = 0; k < 8; k++) {

				// 가로 탐색
				for (int i = 0; i < 8 - N + 1; i++) {

					// 탐색 범위
					int start = i;
					int end = i + N - 1;
					boolean check = true;

					while (start <= end) {
						if (arr[k][start] == arr[k][end]) {
							start++;
							end--;
						} else {
							check = false;
							break;
						}
						check = true;
					}

					if (check)
						cnt++;

				}

				// 세로 탐색
				for (int i = 0; i < 8 - N + 1; i++) {

					// 탐색 범위
					int start = i;
					int end = i + N - 1;
					boolean check = true;

					while (start <= end) {
						if (arr[start][k] == arr[end][k]) {
							start++;
							end--;
						} else {
							check = false;
							break;
						}
						check = true;
					}

					if (check)
						cnt++;
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}
}
