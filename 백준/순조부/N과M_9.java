package 순열조합;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 순열 - 중복배열 제거(중복된 숫자가 있는 배열을 입력받음)
public class N과M_9 {

	static int N, M;
	static int[] arr;
	static int[] tmp;
	static boolean[] isSelected;

	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();

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

		System.out.println(sb.toString());

	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			StringBuilder sb2 = new StringBuilder(); // 비교할 임시
			for (int i = 0; i < M; i++) {
				sb2.append(tmp[i]).append(" ");
			}
			if (!set.contains(sb2.toString())) { // 중복제거
				sb.append(sb2.toString()).append("\n");
				set.add(sb2.toString());
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				tmp[cnt] = arr[i];

				isSelected[i] = true;
				permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
	}
}
