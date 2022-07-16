import java.util.Scanner;

public class N1946_간단한압축풀기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			StringBuilder sb = new StringBuilder();

			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {

				String str = sc.next();

				int cnt = sc.nextInt();
				for (int k = 1; k <= cnt; k++) {
					sb.append(str);
				}
			}

			System.out.println("#" + i);
			while (sb.length() >= 10) {
				System.out.println(sb.substring(0, 10));
				sb.delete(0, 10);
			}
			System.out.println(sb.substring(0));
		}

	}
}
