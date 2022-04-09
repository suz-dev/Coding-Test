package Level1;

public class 자릿수더하기 {
	public int solution(int n) {
		int answer = 0;

		char[] ch = Integer.toString(n).toCharArray();

		for (char c : ch) {
			answer += c - '0';
		}

		return answer;
	}
}