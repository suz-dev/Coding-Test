import java.util.Arrays;
import java.util.Scanner;

/*
 * N번째 큰 수
 */
public class N2693 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // TC개수

		StringBuilder sb = new StringBuilder();
		int[] A = new int[10];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < A.length; j++) {
				A[j] = sc.nextInt();
			}
			Arrays.sort(A);
			sb.append(A[A.length - 3] + "\n");
		}
		
		System.out.println(sb.toString());

	}

}
