package Kakao;

import java.util.Arrays;

public class 예산 {
	public int solution(int[] d, int budget) {
		int answer = 0;

		Arrays.sort(d);
		int sum = 0;

		for (int i = 0; i < d.length; i++) {
			if (sum <= budget && sum + d[i] <= budget) {
				answer++;
				sum += d[i];
			}
		}

		return answer;
	}
}
