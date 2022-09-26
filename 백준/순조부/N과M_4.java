package 순조부특공대;

import java.util.Scanner;

// 아래 조건을 만족하는 길이가 M인 수열(중복조합)
public class N과M_4 {

	static int N;
	static int M;
	static int[] tmp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		tmp = new int[M];

		Combination(0, 1);
		System.out.println(sb);

	}

	// 중복조합
	private static void Combination(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {
			tmp[cnt] = i;
			Combination(cnt + 1, i);
		}
	}
}
