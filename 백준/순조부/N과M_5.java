package 순조부특공대;

import java.util.Scanner;

// nCr, 중복X
public class N과M_5 {

	static int N;
	static int M;
	static int[] arr;
	static int[] tmp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		tmp = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Combination(0, 0);
		System.out.println(sb);

	}

	// 조합
	private static void Combination(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i < N; i++) {
			tmp[cnt] = arr[i];
			Combination(cnt + 1, i + 1);
		}
	}
}
