package d3_d4;

import java.util.Scanner;

public class 원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next(); // 원래값

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				sb.append(0);
			}

			int cnt = 0; // 수정 횟수
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != sb.charAt(i)) { // 같은 자리 순서의 값이 다를 경우
					String s = String.valueOf(str.charAt(i));
					for (int j = i; j < str.length(); j++) { // i부터 끝까지 바꾸기
						sb.replace(j, str.length(), s);
					}
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}