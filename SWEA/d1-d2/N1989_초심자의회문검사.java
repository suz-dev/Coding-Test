package d1_d2;

import java.util.Scanner;

public class N1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();

			int check = 1;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					check = 0;
				}
			}

			System.out.println("#" + t + " " + check);
		}
	}
}
