import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 1. 배열에 정수 x (x ≠ 0)를 넣는다.
 * 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 
 * 입력
 * 1. 연산의 개수 N - BufferedReader
 * 2. N만큼 배열의 값 X 입력 - PriorityQue(람다식으로 절대값 비교 조건 추가)
 * 
 * 동작
 * PriorityQue 배열
 * StringBuilder 배열(출력값 용)
 * x != 0
 * - pq.add(X)
 * x == 0
 * - 배열에서 절댓값이 가장 작은 값 출력
 * - pq.size() == 0 일 때 0 출력
 * 
 * 출력
 * StringBuilder 값 출력
 */
public class N11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 연산의 개수

		/*
		 * 우선순위 조건 조절 - 절대값의 크기가 같을 경우 o1, o2 비교 - 절대값의 크기가 다를 경우 o1, o2의 절대값 비교 리턴값이 1일
		 * 경우 순서 교체
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs_a = Math.abs(o1);
			int abs_b = Math.abs(o2);
			if (abs_a == abs_b) {
				return o1.compareTo(o2);
			} else {
				return (abs_a - abs_b) < 0 ? -1 : 1;
			}
		});

		StringBuilder sb = new StringBuilder();

		/*
		 * PriorityQue 배열값 입력받기
		 */
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());

			if (X == 0) {
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append('\n');
			} else {
				pq.add(X);
			}
		}

		System.out.println(sb.toString());

	}

}
