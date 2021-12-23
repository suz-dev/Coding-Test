package arrays101;

import java.util.Arrays;

public class SquaresOfASortedArray {

	// Time Complexity: O(N log N), Space Complexity: O(log N)

	public int[] sortedSquares(int[] nums) {

		int[] arr = new int[nums.length]; // nums 배열의 요소들을 각각 제곱하여 저장할 배열 arr 선언

		for (int i = 0; i < nums.length; i++) {
			arr[i] *= arr[i];
		}

		Arrays.sort(arr); // 오름차순 정렬 메소드
		return arr;
	}
}
