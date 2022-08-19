package d3_d4;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class 퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 카드 개수
			LinkedList<String> string = new LinkedList<>();

			// 카드 입력받기
			for (int i = 0; i < N; i++) {
				string.add(sc.next());
			}

			Stack<String> stack1 = new Stack<>();
			Stack<String> stack2 = new Stack<>();

			int mid = N / 2;

			// N이 홀수일 때 (중간값은 마지막으로)
			String tmp = "";
			if (N % 2 != 0) {
				tmp = string.remove(mid);
			}

			for (int i = string.size() - 1; i >= 0; i--) {
				if (i < mid) { // 절반 앞
					stack1.add(string.get(i));
				} else { // 절반 뒤
					stack2.add(string.get(i));
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!stack2.isEmpty()) {
				sb.append(stack1.pop()).append(" ");
				sb.append(stack2.pop()).append(" ");
			}
			sb.append(tmp);

			System.out.println("#" + t + " " + sb);
		}
	}
}