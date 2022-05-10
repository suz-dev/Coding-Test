import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백만 장자 프로젝트
public class N1859 {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<Integer>();
		Long cost = 0L;

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // TC 개수

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt(); // 물건 가격 예측 가능 일수
			String[] S = sc.next().split(" ");	// 날짜별 물건 가격

			for (int j = 0; j < S.length; j++) {
				que.add(Integer.parseInt(S[j]));
			}

			int max = 0; // 판매 최대가
			for (int j : que) {
				max = Math.max(max, i);
			}

			while (!que.isEmpty()) {

				if (que.peek() < max) {
					cost += max - que.poll(); // 판매가 - 구매가
				} else if (que.peek() == max) {
					que.poll();
					for (int j : que) { // max값 재설정
						max = Math.max(max, i);
					}

				}
			}
			
			System.out.println(cost);

		}
	}

}
