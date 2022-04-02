package Level1;

import java.util.ArrayList;

public class MinNumDelete {

	public int[] solution(int[] arr) {
		int[] answer = {};

		if (arr.length == 1) {
			return new int[] { -1 };
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		answer = new int[arr.length - 1];

		int min = arr[0];
		for (int i : arr) {
			min = Math.min(min, i);
		}

		for (int i : arr) {
			if (i != min) {
				list.add(i);
			}
		}

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}