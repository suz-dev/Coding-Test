package d3_d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 준홍이의카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 세트1: 1번 ~ N번
			int M = sc.nextInt(); // 세트2: 1번 ~ M번

			int[] arr = new int[M + N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i + j]++;
				}
			}

			// 개수가 가장 많은 값 구하기
			int max = 1;
			for (int i = 0; i < M + N + 1; i++) {
				max = Math.max(max, arr[i]);
			}

			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < M + N + 1; i++) {
				if (arr[i] == max)
					list.add(i);
			}

			Collections.sort(list);

			// 출력
			System.out.print("#" + t + " ");
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}