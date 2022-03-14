import java.util.Scanner;

public class N10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = 0; // 최종 층
		int w = 0; // 최종 호실

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int i = 0; i < T; i++) {

			int H = sc.nextInt(); // 호텔의 층 수
			int W = sc.nextInt(); // 각 층의 방 수
			int N = sc.nextInt(); // 몇 번째 손님

			if (N % H != 0) {
				h = (N % H);
				w = (N / H) + 1;

			} else {
				h = H;
				w = N / H;
			}

			System.out.println((100 * h) + w);
		}

	}

}
