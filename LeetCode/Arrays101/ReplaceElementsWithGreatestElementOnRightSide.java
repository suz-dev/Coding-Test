package arrays101;

/*
 * 해당 인덱스의 오른쪽 요소들 중 가장 큰 요소 반환 (마지막은 -1 반환)
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

	public int[] replaceElements(int[] arr) {

		int max = -1;

		// 배열 역순으로 반복문 실행
		for (int i = arr.length - 1; i >= 0; i--) {
			int tmp = arr[i];
			arr[i] = max;
			if (tmp > max) {
				max = tmp;
			}
		}
		return arr;
	}
}
