package Level1;

import java.util.ArrayList;

public class 소수만들기 {
	public int solution(int[] nums) {
		int answer = 0;

		// nums의 서로 다른 요소 3개 더하기
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					list.add(nums[i] + nums[j] + nums[k]);
				}
			}
		}

		// 소수 찾기
		int cnt = 0;
		for (int i : list) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					cnt++;
				}
			}
			if (cnt == 1) {
				answer++;
			}
			cnt = 0;
		}
		return answer;
	}
}