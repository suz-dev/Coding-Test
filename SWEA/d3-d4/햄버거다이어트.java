package d3_d4;

import java.util.Scanner;

// 부분집합 활용
public class 햄버거다이어트 {

	static int N; // 재료의 수
	static int K; // 제한 칼로리

	static int[] taste; // 맛점수
	static int[] Kcal; // 칼로리
	static boolean[] check; // 들어간 재료 체크

	// 칼로리를 넘지 않고, 맛 점수가 가장 높을 때
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // tc 개수
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 재료의 수
			K = sc.nextInt(); // 제한 칼로리

			taste = new int[N];
			Kcal = new int[N];
			check = new boolean[N];

			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				Kcal[i] = sc.nextInt();
			}

			max = 0;
			checkSum(0);
			System.out.println("#" + t + " " + max);

		}
	}

	static int max = 0;

	static void checkSum(int idx) {
		int Tsum = 0; // 맛점수
		int Ksum = 0; // 칼로리
		// 기저 조건
		if (idx == taste.length) {
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					Tsum += taste[i];
					Ksum += Kcal[i]; // 칼로리 누적
				}
			}

			if (Ksum <= K) {
				max = Math.max(max, Tsum);
			}
			return;
		}

		// 실행
		check[idx] = true; // 포함되어 있을 때
		checkSum(idx + 1);

		check[idx] = false; // 포함되어 있지 않을 때
		checkSum(idx + 1);

	}
}