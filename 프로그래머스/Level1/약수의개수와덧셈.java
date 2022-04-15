package Level1;

public class 약수의개수와덧셈 {
	public int solution(int left, int right) {

		int sum = 0;
		int divisorCount = 0;

		for (int i = left; i <= right; i++) {
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					divisorCount++;
				}
			}
			
			if (divisorCount % 2 == 0) {
				sum += i;
			} else {
				sum -= i;
			}
			
			divisorCount = 0;
		}

		return sum;
	}
}