package Level2;

public class N개의최소공배수 {
	public int solution(int[] arr) {
		int answer = arr[0];

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				answer = lcm(answer, arr[j]);
			}
		}

		return answer;
	}

	// 최소공배수
	public int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	// 최대공약수
	public int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}