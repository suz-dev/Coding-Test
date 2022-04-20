package Level2;

public class JadenCase {
	public String solution(String s) {
		String answer = "";
		String[] str = s.split(" ");

		if (s.substring(s.length() - 1, s.length()).equals(" ")) {
			str[str.length - 1] += " ";
		}
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				if (j == 0) {
					answer += Character.toUpperCase(str[i].charAt(j));
				} else {
					answer += Character.toLowerCase(str[i].charAt(j));
				}
			}

			if (i < str.length - 1) {
				answer += " ";
			}
		}

		return answer;
	}
}
