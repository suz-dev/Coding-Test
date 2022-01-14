import java.util.Scanner;

public class N10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int fac = 1;

		for (int i = sc.nextInt(); i > 0; i--) {
			fac *= i;
		}

		System.out.println(fac);

	}

}
