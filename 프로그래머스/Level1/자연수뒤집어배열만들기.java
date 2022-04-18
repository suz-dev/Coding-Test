package Level1;

public class 자연수뒤집어배열만들기 {
	public int[] solution(int n) {

		String str = new StringBuilder(Long.toString(n)).reverse().toString();

		int[] answer = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			answer[i] = str.charAt(i) - '0';
		}

		return answer;
	}
}