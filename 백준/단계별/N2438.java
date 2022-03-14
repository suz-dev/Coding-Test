import java.util.Scanner;

/**
 * 2438 -> 2439
 */
public class N2438 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

}
