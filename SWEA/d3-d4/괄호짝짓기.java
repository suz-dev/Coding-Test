package d3_d4;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // tc 길이
			String str = sc.next(); // tc

			// 1: 유효 0: 유효X
			int check = 1;

			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < N; i++) {

				if (str.charAt(i) == '<' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
					stack.add(str.charAt(i));

				} else if (str.charAt(i) == '>' && stack.peek() == '<' || str.charAt(i) == ')' && stack.peek() == '('
						|| str.charAt(i) == '}' && stack.peek() == '{' || str.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
				} else {
					break;
				}

			}

			if (!stack.isEmpty())
				check = 0;

			System.out.println("#" + t + " " + check);
		}
	}

}