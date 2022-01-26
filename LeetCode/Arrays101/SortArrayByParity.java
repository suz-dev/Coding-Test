package arrays101;

// 짝수 요소를 앞으로 당기기
public class SortArrayByParity {

	public int[] sortArrayByParity(int[] nums) {

		int OddToEven = 0;

		for (int j = 0; j < nums.length; j++) {

			if (nums[j] % 2 == 0) { // 짝수 요소가 들어있는 인덱스

				// 홀수 요소와 위치 바꾸기
				int tmp = nums[OddToEven];
				nums[OddToEven] = nums[j];
				nums[j] = tmp;

				OddToEven++;
			}
		}
		return nums;

	}
}