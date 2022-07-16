import java.util.Scanner;

public class N2058_자릿수더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String str = String.valueOf(N);

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}

		System.out.println(sum);

	}

}
