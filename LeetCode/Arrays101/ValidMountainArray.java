package arrays101;

public class ValidMountainArray {
	public boolean validMountainArray(int[] arr) {
		
		// 배열의 길이가 최소 3일 때 mountain(꺾는점)이 생긴다
		if (arr.length < 3)
			return false;

		int start = 0;	// 배열의 시작
		int end = arr.length - 1;	// 배열의 끝	

		while (start < end) {
			if (arr[start + 1] > arr[start]) {	// 인덱스가 배열의 시작부터 오름차순
				start++;
			} else if (arr[end - 1] > arr[end]) {	// 인덱스가 배열의 끝에서부터 역방향 오름차순
				end--;
			} else {
				break;
			}
		}
		
		// 만나는 점이 배열의 시작과 끝이 아닌 결과 
		return start != 0 && end != arr.length - 1 && start == end;
	}
}