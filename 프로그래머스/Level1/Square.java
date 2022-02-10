package Level1;

/*
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, 
 * n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 */
public class Square {

	public long solution(long n) {
		long answer = -1;
		long sqrt = (long) Math.sqrt(n);

		if (Math.pow(sqrt, 2) == n) {
			answer = (long) Math.pow(sqrt + 1, 2);
		}

		return answer;
	}
}