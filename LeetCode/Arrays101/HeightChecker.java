package arrays101;

import java.util.Arrays;

// 무작위로 나열된 수로 이루어진 배열에 대하여 오름차순으로 정렬했을 때, 
// 기존 배열과 요소가 일치하지 않는 인덱스의 개수를 반환

public class HeightChecker {

	public int heightChecker(int[] heights) {

		int[] expected = Arrays.copyOf(heights, heights.length);
		Arrays.sort(expected);

		int cnt = 0;

		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != expected[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}