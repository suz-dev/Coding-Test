package Sort;

import java.util.Arrays;

/*
 * 입력
 * 1 <= numbers.length <= 100,000
 * 1 <= numbers 원소 <= 1,000
 * 
 * 동작
 * 입력받은 배열의 원소들을 이어붙였을 때 가장 큰 수가 되는 조합을 return
 * 원소 두개를 순서 바꿔 이어붙였을 때 더 큰 값을 return 
 * 
 * 출력
 * 문자열로 return 
 */
public class 가장큰수 {

	public String solution(int[] numbers) {
		String answer = "";

		String[] str = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(str, (o1, o2) -> {

			// ex) 30, 31 에 대해 3130 3031 비교 : o2+o1 이 더 클 경우 자리 바꾸기
			return ((o2 + o1).compareTo(o1 + o2));
		});

		// 0으로만 이루어진 배열이 있을 경우 하나의 0만 리턴
		if (str[0].equals("0")) {
			return "0";
		}

		for (String a : str) {
			answer += a;
		}

		return answer;
	}

}
