
class Solution {

	public static int MaxConsecutiveOnes(int[] nums) {

		int cnt = 0;
		int result = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 1) {
				cnt++;
				result = Math.max(cnt, result); // if문 대신 Math.max()메소드 활용
			} else {
				cnt = 0;
			}
		}
		return result;
	}

}
