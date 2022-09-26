package 순조부특공대;

import java.util.Arrays;
import java.util.Scanner;

// 중복순열
public class N과M_7 {

	static int N, M;
	static int[] arr, tmp;
	static boolean[] isSelected;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		tmp = new int[M];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		permutation(0);
		System.out.println(sb);

	}

	// 중복 순열
	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');

			return;
		}

		for (int i = 0; i < N; i++) {
			tmp[cnt] = arr[i];
			permutation(cnt + 1);
		}

	}
}
