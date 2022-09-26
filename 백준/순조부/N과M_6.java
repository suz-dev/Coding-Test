package 순조부특공대;

import java.util.Arrays;
import java.util.Scanner;

// 순열
public class N과M_6 {

	static int N;
	static int M;
	static int[] arr;
	static int[] tmp;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		tmp = new int[M];
		arr = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		Permutation(0);
		System.out.println(sb);

	}

	private static void Permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(' ');
			}
			sb.append('\n');

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				tmp[cnt] = arr[i];

				isSelected[i] = true;
				Permutation(cnt + 1);
				isSelected[i] = false;
			}
		}

	}
}
