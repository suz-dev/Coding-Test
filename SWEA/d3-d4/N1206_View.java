package d3_d4;

import java.util.Scanner;

public class N1206_View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt();

			// 건물이 세워진 땅
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int cnt = 0; // 조망권 확보 세대
			int max = 0;
			for (int i = 2; i < N - 2; i++) {
				// 앞 2건물, 뒤 2건물 높이 비교
				max = Math.max((Math.max(arr[i - 2], arr[i - 1])), (Math.max(arr[i + 1], arr[i + 2])));
				if (arr[i] > max) {
					cnt += arr[i] - max;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
