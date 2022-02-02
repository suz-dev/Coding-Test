import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 */
public class N1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 입력받을 단어 개수
		String[] st = new String[N];

		sc.nextLine();	// 개행 버림 (왜?)

		for (int i = 0; i < N; i++) {
			st[i] = sc.nextLine();
		}

		Arrays.sort(st, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어 길이가 같을 경우
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// 그 외의 경우
				else {
					return s1.length() - s2.length();
				}
			}
		});

		System.out.println(st[0]);

		// 중복되지 않는 단어만 출력
		for (int i = 1; i < N; i++) {
			if (!st[i].equals(st[i - 1])) {
				System.out.println(st[i]);
			}
		}

	}

}
