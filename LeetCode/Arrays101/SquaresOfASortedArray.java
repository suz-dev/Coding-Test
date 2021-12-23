package arrays101;
import java.util.Arrays;

public class SquaresOfASortedArray {

	// Time Complexity: O(N log N), Space Complexity: O(log N)

	public int[] sortedSquares(int[] nums) {

		int[] arr = new int[nums.length]; // nums�迭�� ��ҵ��� ���� �����Ͽ� ������ �迭 arr ����

		for (int i = 0; i < nums.length; i++) {
			arr[i] *= arr[i];
		}

		Arrays.sort(arr); // �������� ���� �޼ҵ�
		return arr;
	}
}
