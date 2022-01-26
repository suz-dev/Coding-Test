package arrays101;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		int index = 0; // 0이 아닌 수를 넣을 인덱스

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) { // 요소가 0이 아닐 때
				nums[index] = nums[i];
				index++;
			}
		}

		// 0이 아닌 수를 앞으로 당겨 넣은 뒤 남은 인덱스에 0 채워넣기
		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
