import java.util.Scanner;

public class N2675 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int i = 0; i < T; i++) {

			int R = sc.nextInt(); // 반복할 길이
			String S = sc.next(); // 입력받는 단어 ('nextLin()' 사용시 공백까지 읽음)

			for (int j = 0; j < S.length(); j++) {

				for (int k = 0; k < R; k++) {
					System.out.print(S.charAt(j));
				}
			}

			System.out.println();
		}
		sc.close();
	}
}
