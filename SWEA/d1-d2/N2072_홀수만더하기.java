package d1_d2;
import java.util.Scanner;

// 홀수만 더하기
public class N2072_홀수만더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			int sum = 0;

			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i : arr) {
				if (i % 2 != 0) {
					sum += i;
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}
	}
}