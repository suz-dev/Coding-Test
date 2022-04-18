package Level1;

import java.util.ArrayList;

public class 같은숫자는싫어 {
	public int[] solution(int[] arr) {
		int[] answer = {};

		int preIndexValue = -1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : arr) {
			if (i != preIndexValue) {
				list.add(i);
				preIndexValue = i;
			}
		}

		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
