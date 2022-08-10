package 단계별;

import java.util.Scanner;

public class N2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 색종이 개수
		boolean[][] check = new boolean[100][100]; // 도화지

		int cnt = 0; // 겹치는 부분

		for (int t = 0; t < n; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 색종이 범위
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {

					// 이미 체크된 경우 다음으로 (중복 방지)
					if (check[i][j] == true)
						continue;

					// 체크가 되지 않은 경우 체크
					check[i][j] = true;
					++cnt;
				}
			}
		}
		System.out.println(cnt);
	}
}