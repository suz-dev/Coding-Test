import java.util.Scanner;

public class N10952 {

	/**
	 * 10952 -> 10951 입력값이 0으로 끝나지 않을 때, 더이상 읽을 수 없는 데이터(EOF)가 없을 때 종료
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(a + b);

		}
		sc.close();

	}
}


