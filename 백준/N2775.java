import java.util.Scanner;

// re
public class N2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] apt = new int[15][15];

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int t = 0; t < T; t++) {

			int k = sc.nextInt(); // 층수
			int n = sc.nextInt(); // 호수

			for (int i = 0; i <= k; i++) {
				for (int j = 0; j <= n; j++) {

					if (i == 0) {
						apt[i][j] = j;
					} else if (j == 0) {
						apt[i][j] = i;
					} else if (j == 1) {
						apt[i][j] = 1;
					} else {
						apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
					}
				}
			}
			System.out.println(apt[k][n]);
		}

	}

}
