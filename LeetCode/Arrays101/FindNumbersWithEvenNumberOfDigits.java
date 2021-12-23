package arrays101;

public class FindNumbersWithEvenNumberOfDigits {

	public int findNumbers(int[] nums) {

		int even = 0; // 자릿수의 개수가 짝수인 요소
		int cnt = 0; // 자릿수의 수

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0) { // nums[i]가 0보다 클 동안 반복
				nums[i] /= 10; // 10씩 나누어 자릿수 구하기
				cnt++; // 10씩 나눈만큼 cnt값 +1
			}

			if (cnt % 2 == 0) { // cnt값이 짝수일 경우 even++ 실행
				even++;
			}
			cnt = 0; // 다음 요소를 위해 cnt 값을 0으로 설정
		}

		return even; // 짝수 자리수의 숫자의 개수 even값 리턴
	}

}
