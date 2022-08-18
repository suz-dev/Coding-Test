package d3_d4;

import java.util.Scanner;
import java.util.Stack;

public class 계산기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // 문자열의 길이
			String str = sc.next(); // 수식

			// 후위표기식 전환 ((+만 있음)
			Stack<Character> stack = new Stack<Character>();
			String postFix = "";
			for (int i = 0; i < N; i++) {
				if (str.charAt(i) != '+') {
					postFix += str.charAt(i);
				} else {
					if (stack.isEmpty())
						stack.add(str.charAt(i));
					else {
						postFix += stack.pop();
						stack.add(str.charAt(i));
					}
				}
			}

			while (!stack.isEmpty())
				postFix += stack.pop();

			// 후위표기식 연산
			Stack<Integer> cal = new Stack<Integer>();
			for (int i = 0; i < N; i++) {
				if (postFix.charAt(i) != '+') {
					cal.add(postFix.charAt(i) - '0');
				} else {
					cal.add(cal.pop() + cal.pop());
				}
			}

			System.out.println(cal.pop());
		}

	}

}
