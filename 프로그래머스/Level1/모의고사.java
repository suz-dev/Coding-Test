package Level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 모의고사 {

	static int[] correct = new int[3];
	static int k = 0; // correct index

	public ArrayList<Integer> solution(int[] answers) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		// 수포자 3인방
		int[] s1 = { 1, 2, 3, 4, 5 };
		int[] s2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] s3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		Correct(answers, s1);
		Correct(answers, s2);
		Correct(answers, s3);

		int max = 0;
		for (int i = 0; i < correct.length; i++) {
			max = Math.max(max, correct[i]);
		}

		for (int i = 0; i < correct.length; i++) {
			if (correct[i] == max) {
				list.add(i + 1);
			}
		}

		return list;
	}

	public void Correct(int[] answers, int[] s) {

		Queue<Integer> K = new LinkedList<Integer>();
		for (int i : s) {
			K.add(i);
		}

		int cnt = 0; // 정답 맞춘 개수
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == K.peek()) {
				cnt++;
			}
			K.add(K.poll());
		}
		correct[k] = cnt;
		k++;
	}

}