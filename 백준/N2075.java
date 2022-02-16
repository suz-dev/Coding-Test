
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * N번째 큰 수
 * N×N의 표에 수 N2개 채워져 있다. 
 * 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다.
 * 이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. (표에 채워진 수는 모두 다르다)
 * 
 * 입력 - Scanner 사용
 * 정수 N 입력 
 * N*N 만큼의 수 입력
 * 
 * 동작
 * PriorityQue를 사용하여 입력받은 수 내림차순 정렬 후 저장 
 * (Collections.reverseOrder() 사용)
 * 
 * 출력
 * N번째로 큰 수를 출력해야 하므로 우선순위큐에서 N번 poll 실행
 * 마지막으로 poll 한 요소 출력 
 */

public class N2075 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < N * N; i++) {
			pq.add(sc.nextInt());
		}

		for (int i = 0; i < N - 1; i++) {
			pq.poll();
		}

		System.out.println(pq.poll());
	}

}
