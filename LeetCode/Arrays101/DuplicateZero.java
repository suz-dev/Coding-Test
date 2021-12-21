
public class DuplicateZero {
	
	//Input: arr = [1,0,2,3,0,4,5,0]
	//Output: [1,0,0,2,3,0,0,4]
	//Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

	public void duplicateZeros(int[] arr) {

		// arr[i]의 요소를 한칸씩 뒤로 밀어야 하기 때문에 길이는 arr.length-1 로 설정
		for (int i = 0; i < arr.length - 1; i++) {
 
			/*
			 * arr[i] == 0 일 경우만 실행
			 * arr[3]일 경우 arr.length = 4 이기 때문에 j = arr.length - 2 로 초기화한다
			 * 반복문을 통해 arr[j + 1]의 요소부터 arr[j] 요소까지 한칸씩 뒤로 이동시킨다
			 * 요소이동이 끝나면 i++를 실행한 뒤 비어있는 arr[i]에 0을 넣어준다
			 */
			if (arr[i] == 0) {
				for (int j = arr.length - 2; j > i; j--) {
					arr[j + 1] = arr[j];
				}
				i++;
				arr[i] = 0;
			}
		}
	}

}

