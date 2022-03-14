import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 최소 힙
 * 
 * 입력
 * 1. 연산의 개수 N 입력 - BufferedReader 사용
 * 2. N만큼 정수 X 입력  - PriorityQue 배열 생성
 * 
 * 동작
 * 출력할 값은 StringBuilder에 추가
 * X == 0
 * - 배열에서 가장 작은 값 출력 후 제거
 * - 배열이 비었을 때 0 출력
 * X != 0
 * - 배열에 X 추가
 * 
 * 출력
 * StringBuilder에 저장된 값 한줄에 하나씩 출력
 */
public class N1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());

			if (X == 0) {
				sb.append(que.size() == 0 ? 0 : que.poll()).append('\n');
			} else {
				que.add(X);
			}
		}

		System.out.println(sb.toString());
	}

}
