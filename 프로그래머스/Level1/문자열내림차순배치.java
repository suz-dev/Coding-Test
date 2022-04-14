package Level1;

import java.util.Arrays;

public class 문자열내림차순배치 {
	public String solution(String s) {
		String answer = "";

		char[] ch = s.toCharArray();
		Arrays.sort(ch);

		for (int i = ch.length - 1; i >= 0; i--) {
			answer += ch[i];
		}
		return answer;
	}
}