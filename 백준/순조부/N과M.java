package 순조부특공대;

import java.util.Scanner;

public class N과M {

	static int N;
	static int M;

	static int[] tmp;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 1~N 을
		M = sc.nextInt(); // M개 고른 수열 모두 구해라

		tmp = new int[M];
		visited = new boolean[N + 1];

		permutation(0);
	}

	static void permutation(int cnt) {

		// 깊이 check
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;

				tmp[cnt] = i;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}