package 순조부특공대;

import java.util.Scanner;

// 조합
public class N과M_2 {

	static int N;
	static int M;
	static int[] tmp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // n
		M = sc.nextInt(); // r

		tmp = new int[N];

		Combination(0, 1);	// 1~N까지의 수 
		System.out.println(sb);
	}

	static void Combination(int cnt, int start) {
		if (cnt == M) {
			for (int i : tmp) {
				if (i != 0)
					sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {
			tmp[cnt] = i;
			Combination(cnt + 1, i + 1);
		}
	}
}
