package d1_d2;
import java.util.Scanner;

public class N1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];

		for (int i = 0; i < T; i++) {
			String str = sc.next();

			for (int j = 0; j < str.length() / 2; j++) {
				if (str.charAt(j) == str.charAt((str.length() - 1) - j)) {
					arr[i] = 1;
					continue;

				} else {
					arr[i] = 0;
					break;
				}
			}

		}

		for (int i = 1; i <= arr.length; i++) {
			System.out.println("#" + i + " " + arr[i - 1]);

		}

	}
}
