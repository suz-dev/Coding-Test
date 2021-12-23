package arrays101;
import java.util.Arrays;

public class MergeSortedArray {

	/*
	 * nums1.length == m + n 
	 * nums2.length == n 
	 * 0 <= m, n <= 200 
	 * 1 <= m + n <= 200
	 * -10^9 <= nums1[i], nums2[j] <= 10^9 ('j'활용  X)
	 */
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		for (int i = m; i < nums1.length; i++) {
			nums1[i] = nums2[i - m];
		}
		Arrays.sort(nums1);
	}

}
