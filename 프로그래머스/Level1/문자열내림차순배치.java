package Level1;

import java.util.Arrays;

public class 문자열내림차순배치 {
	public String solution(String s) {
		String answer = "";

		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		answer = new StringBuilder(new String(ch)).reverse().toString();
		
		return answer;
	}
}