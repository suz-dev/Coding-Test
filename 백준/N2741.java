import java.util.Scanner;

/**
 * 자연수 'N'이 주어졌을 때, 1부터 'N'까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오. 
 * 'for'문 사용
 */
public class N2741 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();

		for (int i = 1; i <= N; i++) {
			System.out.println(i);
		}
	}

}
