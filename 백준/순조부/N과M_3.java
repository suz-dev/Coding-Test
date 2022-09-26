package 순조부특공대;

import java.util.Scanner;

// 아래 조건을 만족하는 길이가 M인 수열 (중복 순열)
public class N과M_3 {

	static int N;
	static int M;
	static int[] tmp;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		tmp = new int[M];
		isSelected = new boolean[N + 1];

		Permutation(0);
		System.out.println(sb);
		sc.close();

	}

	private static void Permutation(int cnt) {

		if (cnt == M) {
			for (int i = 0; i < tmp.length; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			tmp[cnt] = i;
			Permutation(cnt + 1);
		}
	}
}
