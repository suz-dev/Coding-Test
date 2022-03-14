import java.util.Scanner;

public class N2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 입력 수

		int cnt = 1; // N까지 지나갈 방 개수 (겹)

		int range = 2; // 범위 최솟값

		if (N == 1) {
			System.out.println(1);
		} else {
			while (range <= N) { // N보다 커지기 직전까지 반복
				range = range + (cnt * 6);
				cnt++;
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
