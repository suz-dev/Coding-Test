import java.util.Scanner;

public class N2978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 카드의 수
		int M = sc.nextInt(); // 한도 수

		int win = 0; // M에 가장 가까운 수

		int[] card = new int[N];

		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (card[i] + card[j] + card[k] > win && card[i] + card[j] + card[k] <= M) {
						win = card[i] + card[j] + card[k];
					}
				}
			}
		}

		System.out.println(win);

	}

}
