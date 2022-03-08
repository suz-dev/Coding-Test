
import java.util.LinkedList;
import java.util.Scanner;

public class N1966 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int TC = sc.nextInt(); // TC 개수

		// TC 만큼 반복
		while (TC-- > 0) {

			int N = sc.nextInt(); // 입력할 문서 개수
			int M = sc.nextInt(); // 출력 순서를 찾고자 하는 배열의 인덱스

			LinkedList<int[]> que = new LinkedList<int[]>();

			// que에 {초기위치, 중요도} 배열로 채우기
			for (int i = 0; i < N; i++) {
				que.offer(new int[] { i, sc.nextInt() });
			}

			int cnt = 0;

			// 한 TC에 대한 반복문
			while (!que.isEmpty()) {

				int[] first = que.poll(); // 첫 원소
				boolean isMax = true; // first가 가장 큰 원소인지 판단

				// 큐에 남아있는 원소들과 중요도 비교
				for (int i = 0; i < que.size(); i++) {

					// 처음 뽑은 원소보다 큐에 있는 i번째 원소의 중요도가 큰 경우
					if (first[1] < que.get(i)[1]) {

						// 처음 뽑은 원소 & i이전의 원소를 뽑아 뒤로 보내기
						que.offer(first);
						for (int j = 0; j < i; j++) {
							que.offer(que.poll());
						}

						// 처음뽑은 원소가 최대값이 아니므로 false
						isMax = false;
						break;
					}

				}

				// first원소가 최대값이 아니었으므로 다음 반복문으로 넘어감
				if (isMax == false) {
					continue;
				}

				// first원소가 최대값일 경우 해당 원소는 출력해야 하는 문서
				cnt++;
				if (first[0] == M) { // first 문서의 인덱스 (first[0])가 M과 같다면 해당 테스트케이스 종료
					break;
				}
			}

			sb.append(cnt).append('\n');

		}
		System.out.println(sb);

	}

}
