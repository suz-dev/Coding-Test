import java.util.LinkedList;
import java.util.Scanner;

// 에라토스테네스의 체
public class N2960 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int deleteCnt = 0; // 지워지는 순서
		int numK = 0; // K번째로 지워지는 수

		// 2 ~ N
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 2; i < N + 1; i++) {
			list.add(i);
		}

		while (!list.isEmpty()) {

			int p = list.getFirst();

			// p의 배수 지우기
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) % p == 0) {
					numK = list.get(i);
					deleteCnt++;
					list.remove(list.get(i));
				}

				// K번째로 지워지는 수 출력
				if (deleteCnt == K) {
					System.out.println(numK);
					break;
				}

			}

		}

	}

}
