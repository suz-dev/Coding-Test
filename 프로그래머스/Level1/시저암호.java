package Level1;

public class 시저암호 {

	public String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (Character.isUpperCase(ch)) { // 대문자
				if (ch + n <= 'Z') {
					answer += (char) (ch + n);
				} else {
					answer += (char) (ch + n - 26);
				}
			}

			if (Character.isLowerCase(ch)) { // 소문자
				if (ch + n <= 'z') {
					answer += (char) (ch + n);
				} else {
					answer += (char) (ch + n - 26);
				}
			}

			if (ch == ' ') { // 공백
				answer += ' ';
			}

		}

		return answer;
	}
}
