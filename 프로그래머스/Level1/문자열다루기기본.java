package Level1;

public class 문자열다루기기본 {
	public boolean solution(String s) {
		boolean answer = true;

		if (s.length() == 4 || s.length() == 6) {
			if (!s.matches("^[0-9]*$")) { // 정규식 사용
				answer = false;
			}
		} else {
			answer = false;
		}

		return answer;
	}
}