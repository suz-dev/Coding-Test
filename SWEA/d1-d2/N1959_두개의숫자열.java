package d1_d2;
import java.util.Scanner;

public class N1959_두개의숫자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}

			int sum = 0;
			int max = 0;
			int start = 0;

			if (A.length <= B.length) {
				for (int i = 0; i < B.length - A.length + 1; i++) {
					for (int j = 0; j < A.length; j++) {
						sum += A[j] * B[j + start];
					}
					start++;
					max = Math.max(max, sum);
					sum = 0;
				}
			} else {
				for (int i = 0; i < A.length - B.length + 1; i++) {
					for (int j = 0; j < B.length; j++) {
						sum += B[j] * A[j + start];
					}
					start++;
					max = Math.max(max, sum);
					sum = 0;
				}
			}
			
			start = 0;
			System.out.println("#" + t + " " + max);

		}

	}

}
