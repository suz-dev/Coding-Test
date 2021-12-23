package arrays101;

public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {

		int cnt = 0;
		int result = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 1) {
				cnt++;
				result = Math.max(cnt, result); // 조건�? ???? Math.max()�????? ????
			} else {
				cnt = 0;
			}
		}
		return result;
	}

}

