package Level1;

import java.util.Arrays;

public class reverseInt {

	public long solution(long n) {
		long answer = 0;

		String str = Long.toString(n);
		char[] arr = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for (char i : arr) {
			sb.append(i);
		}

		answer = Long.parseLong(sb.reverse().toString());

		return answer;
	}
}
