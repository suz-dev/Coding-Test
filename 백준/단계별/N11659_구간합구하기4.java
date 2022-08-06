package 단계별;

import java.util.Scanner;

public class N11659_구간합구하기4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 개수
		int M = sc.nextInt(); // 횟수

		// 누적합 계산은 한번만
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(arr[b] - arr[a - 1]);
		}
	}
}