import java.util.Scanner;

public class N1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 	// 입력받을 수의 개수
		int cnt = 0; 			// k의 약수의 개수
		int p = 0; 				// 소수의 개수

		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			for (int j = 1; j <= k; j++) { // 입력받은 수 k를 1~k로 나누어 약수의 개수를 구하는 반복문
				if (k % j == 0) {
					cnt++; // 약수의 개수 cnt++
				}
			}
			if (cnt == 2) { // 약수의 개수가 2일 때(소수)
				p++; 		// 소수의 개수 +1
				cnt = 0; 	// 다음 수의 약수를 담을 cnt를 0으로 설정
			} else { 		// 소수가 아닐 때
				cnt = 0; 	// cnt = 0
			}

		}
		System.out.println(p); // 소수의 개수 p 출력
	}
}
