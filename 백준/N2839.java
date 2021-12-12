import java.util.Scanner;

// re
public class N2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 배달할 설탕 kg

		int cnt = 0; // 봉지 개수

		while (true) {

			/*
			 * N이 5로 나누어 떨어질 때 가장 적은 봉지의 개수가 됨
			 * 'N/5'의 값 바로 출력 후 반복문 빠져나옴
			 * 
			 * 'N % 5 != 0'일 경우 N에서 3만큼 씩을 빼서 cnt++ 후 반복
			 *  N이 0이 되면 첫번째 반복문으로 돌아가 cnt 출력
			 * 
			 * 'N -= 3'을 통해 'N < 0'이 된다면 '-1'출력 후 break
			 */

			if (N % 5 == 0) {
				cnt += N / 5;
				System.out.println(cnt);
				break;
			} else {
				N -= 3;
				cnt++;
			}

			if (N < 0) {
				System.out.println(-1);
				break;
			}
		}
		sc.close();
	}

}
