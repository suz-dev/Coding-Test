import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 요세푸스 순열
 */
public class N1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백으로 분리

		Queue<Integer> q = new LinkedList<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');

		// 마지막 부분의 출력은 예외적으로 ", "대신 '>'로 출력되기 때문에 출력 시 마지막 원소 전까지만 for문을 적용한다
		while (q.size() > 1) {

			// 맨 앞의 요소를 맨 뒤로 옮긴다
			for (int i = 0; i < K - 1; i++) {
				int val = q.poll();
				q.offer(val);
			}
			sb.append(q.poll()).append(", ");

		}

		sb.append(q.poll()).append('>');
		System.out.println(sb);
	}

}
