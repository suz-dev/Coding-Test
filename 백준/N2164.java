
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();

		// 큐에 값 넣기
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (q.size() > 1) {
			q.poll(); // 첫번 째 값 반환 후 제거
			q.offer(q.poll()); // 그 다음 첫번 째 값의 반환 값을 큐 마지막에 추가
		}

		System.out.println(q.poll()); // 첫번 째 값 출력 후 제거

	}

}
