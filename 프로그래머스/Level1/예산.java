package Level1;

import java.util.Arrays;

public class 예산 {
	public int solution(int[] d, int budget) {
		int count = 0;
		int left = budget;

		Arrays.sort(d);

		for (int i = 0; i < d.length; i++) {
			if (left >= d[i]) {
				left -= d[i];
				count++;
			}
		}

		return count;
	}
}