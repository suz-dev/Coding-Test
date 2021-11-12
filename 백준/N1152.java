import java.util.Scanner;
import java.util.StringTokenizer;

public class N1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		sc.close();

		// 입력받은 'S'에 대해 공백을 기준으로 나눈 토큰들을 'st'에 저장
		StringTokenizer st = new StringTokenizer(S, " ");

		// 'countTokens()': 토큰의 개수를 반환
		System.out.println(st.countTokens());
	}

}
