package Level1;

public class 문자열다루기기본 {
	public boolean solution(String s) {
		boolean answer = true;

		if (s.length() == 4 || s.length() == 6) {
			try {
				Integer.parseInt(s);
			} catch (NumberFormatException e) {	// 예외처리는 실제상황에서만 쓸 것
				answer = false;
			}
		} else {
			answer = false;
		}

		return answer;
	}
}