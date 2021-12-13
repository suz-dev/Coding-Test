
class Solution {

	public static int MaxConsecutiveOnes(int[] nums) {

		int cnt = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 1) {
				cnt++;
				if (cnt > max) {
					max = cnt;
				}
			} else {
				cnt = 0;
			}
		}
		return max;
	}

}

