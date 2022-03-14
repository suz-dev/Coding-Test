import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 * 이후 K개의 줄에 정수가 1개씩 주어진다.
 * 정수는 0에서 1,000,000 사이의 값을 가지며, 
 * 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 */

public class N10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();

		int K = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < K; i++) {
			int inputNum = Integer.parseInt(br.readLine());

			if (inputNum == 0) {
				stack.pop();
			} else {
				stack.push(inputNum);
			}
		}

		for (int k : stack) {
			sum += k;
		}

		System.out.println(sum);
	}

}
