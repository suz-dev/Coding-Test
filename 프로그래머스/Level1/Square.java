package Level1;

/*
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, 
 * n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 */
public class Square {

	public long solution(long n) {
		long answer = 0;

		for (int i = 0; i * i <= n; i++) {
			if (i * i == n) {
				answer = (i + 1) * (i + 1);
			} else {
				answer = -1;
			}

		}

		return answer;
	}
}