package d3_d4;

import java.util.Scanner;

public class String_d3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int tc = sc.nextInt(); // tc

			String str = sc.next(); // 찾을 문자열
			String src = sc.next(); // 검색할 문장

			int cnt = 0;

			for (int i = 0; i < src.length() - str.length(); i++) {
				for (int j = 0; j < str.length(); j++) {
					if (src.charAt(i + j) != str.charAt(j)) {
						break;
					}

					if (j == str.length() - 1) {
						++cnt;
					}
				}
			}

			// 출력 (형식 맞추기)
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
