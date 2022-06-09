import java.util.Scanner;

public class N1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;

		int N = sc.nextInt(); // 입력 단어 a개수
		for (int i = 0; i < N; i++) {
			if (check(sc.next()) == true) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	// 그룹단어 체크
	public static boolean check(String s) {
		boolean[] check = new boolean[26];

		char prev = 0; // 이전 문자
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i); // 현재 문자

			if (prev != now) {

				if (check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				} else {
					return false;
				}

			} else {
				continue;
			}
		}

		return true;
	}

}
