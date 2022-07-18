package d1_d2;
import java.util.Scanner;

public class N1936_1대1가위바위보 {

	// 가위는 1, 바위는 2, 보는 3
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A == 1) {
			if (B == 2) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		} else if (A == 2) {
			if (B == 3) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		} else {
			if (B == 1) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		}
	}

}
