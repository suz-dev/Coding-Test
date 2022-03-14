import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ArrayList 사용 시 시간초과 발생
 */
public class N10448 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[45]; // 삼각수를 담을 배열 (입력받을 자연수 K는 최대 1000 이기 때문에 배열의 길이는 최대 45)

		int T = Integer.parseInt(br.readLine()); // TC 개수
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine()); // 입력받을 자연수

			// 배열에 삼각수 넣기
			for (int j = 1; j <= arr.length; j++) {
				arr[j - 1] = j * (j + 1) / 2;
			}

			System.out.println(eureka(K, arr));
		}

	}

	/*
	 * 입력받은 자연수 K가 삼각수 3개의 합으로 이루어져 있는지 판별
	 */
	private static int eureka(int K, int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {

					if (arr[i] + arr[j] + arr[k] == K) {
						return 1;
					}

				}
			}
		}
		return 0;

	}

}
