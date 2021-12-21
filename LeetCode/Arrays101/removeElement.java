package arrays101;

/*
 * 매개변수 int[] nums, int val
 * val은 nums배열에 포함된 요소(삭제해야 하는 요소)
 * val 삭제 후 남은 요소들을 앞으로 이동
 * 남은 요소들의 길이(k), 배열 반환
 * 
 * 반복문을 통해 배열 검사
 * nums[i]의 요소가 val이 아닐때 
 * nums[k++]에 val이 아닌 nums[i]의 요소를 순차적으로 저장(val이 요소일 겨우 제거)
 * k 리턴
 */
public class removeElement {
	public int removeElement(int[] nums, int val) {

		int k = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k++] = nums[i];

			}
		}
		return k;

	}

}
