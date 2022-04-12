package Kakao;

import java.util.LinkedList;

public class 다트게임 {
	public int solution(String dartResult) {
		int answer = 0;

		char arr[] = dartResult.toCharArray();

		LinkedList<Integer> que = new LinkedList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 < arr.length && arr[i] == '1' && arr[i + 1] == '0') {
				que.add(10);
				i++;
			} else if (arr[i] == '0' || (arr[i] >= '1' && arr[i] <= '9')) {
				que.add(arr[i] - '0');
			} else if (arr[i] == 'S') {
				que.add((int) Math.pow(que.pollLast(), 1));

			} else if (arr[i] == 'D') {
				que.add((int) Math.pow(que.pollLast(), 2));

			} else if (arr[i] == 'T') {
				que.add((int) Math.pow(que.pollLast(), 3));
			} else if (arr[i] == '*') {
				if (que.size() == 1) {
					int temp1 = que.pollLast() * 2;
					que.add(temp1);

				} else {
					int temp2 = que.pollLast() * 2;
					int temp1 = que.pollLast() * 2;
					que.add(temp1);
					que.add(temp2);

				}
			} else if (arr[i] == '#') {
				que.add(que.pollLast() * -1);
			}
		}
		for (Integer i : que) {
			answer += i;
		}
		return answer;
	}
}