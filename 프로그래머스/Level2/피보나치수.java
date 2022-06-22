package Level2;

public class 피보나치수 {
	public int solution(int n) {
		int answer = 0;

		int[] fibonacci = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i < 2) {
				fibonacci[i] = i;
			} else {
				// (A + B) % C = ((A % C)+(B % C)) % C
				fibonacci[i] = fibonacci[i - 1] % 1234567 + fibonacci[i - 2] % 1234567;
			}
		}
		answer = fibonacci[n] % 1234567;

		return answer;
	}

}
