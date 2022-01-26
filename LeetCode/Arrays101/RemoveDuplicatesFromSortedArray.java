package arrays101;

/*
 * 매개변수로  입력받는 nums배열의 요소는 전 인덱스의 요소보다 작아지지 않는다
 * 중복되는 요소는 제거한다
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {

		int i = 0; // 배열의 인덱스 표시

		for (int n : nums) { // 향상된 for문을 통해 배열 원소 추출
			if (i  == 0 || n > nums[i - 1]) { // 배열의 인덱스가 0이거나, nums[i]의 요소(n)가 nums[i - 1] 보다 클 때
				nums[i] = n; // 중복배열 제외 추출
				i++;
			}

		}
		return i;

	}

}
