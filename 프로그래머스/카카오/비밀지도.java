package Kakao;

public class 비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			// 비트논리연산자 or(|) 사용
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
		}

		for (int i = 0; i < n; i++) {
			// String.format()사용 - n개의 자릿수만큼 문자열을 담을 때, 부족할 경우 0으로 자릿수 채우기
			answer[i] = String.format("%" + n + "s", answer[i]);
			
			// answer[i] 에 대해 1->"#", 0->" "으로 대체
			answer[i] = answer[i].replace("1", "#");
			answer[i] = answer[i].replace("0", " ");
		}

		return answer;
	}

}