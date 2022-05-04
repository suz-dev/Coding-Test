package Level1;

// 에라토스테네스의 체 
public class 소수찾기 {
	public int solution(int n) {

		int answer = 0;
		int[] prime = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			prime[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == 0)
				continue;

			for (int j = 2 * i; j <= n; j += i) {
				prime[j] = 0;
			}
		}

		for (int i : prime) {
			if (i != 0) {
				answer++;
			}
		}

		return answer;

	}
}