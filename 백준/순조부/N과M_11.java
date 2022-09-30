package 순열조합;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 중복순열 (중복 결과 제거)
public class N과M_11 {

	static int N, M;
	static int[] arr, tmp;

	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		tmp = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		Permutation(0);

		System.out.println(sb);

	}

	private static void Permutation(int cnt) {
		if (cnt == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb2.append(tmp[i]).append(' ');
			}
			if (!set.contains(sb2.toString())) {
				sb.append(sb2.toString()).append('\n');
				set.add(sb2.toString());
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			tmp[cnt] = arr[i];
			Permutation(cnt + 1);

		}
	}
}
