import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 최대 힙 문제
 * PriorityQue 사용
 */
public class N11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		/*
		 * PriorityQueue는 기본적으로 오름차순이기 때문에 내림차순 정렬 실행
		 */
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder(); // 출력할 que의 요소 저장

		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());

			/*
			 * X == 0 1. que가 비어있을 경우 0 출력 2. que가 비어있지 않을 경우 가장 큰 수 출력(PriorityQue를 내림차순정렬해
			 * 놨기 때문에 가장 앞의 요소 출력)
			 * 
			 * X != 0 que에 입력받은 X 추가
			 */
			if (X == 0) {
				sb.append(que.size() == 0 ? 0 : que.poll()).append('\n');
			} else {
				que.add(X);
			}
		}

		System.out.println(sb.toString());

	}

}
