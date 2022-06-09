import java.util.Scanner;

public class N1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 0;

		int N = sc.nextInt(); // �Է� �ܾ� a����
		for (int i = 0; i < N; i++) {
			if (check(sc.next()) == true) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	// �׷�ܾ� üũ
	public static boolean check(String s) {
		boolean[] check = new boolean[26];

		char prev = 0; // ���� ����
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i); // ���� ����

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
