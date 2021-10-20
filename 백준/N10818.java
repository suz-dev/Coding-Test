import java.util.Arrays;
import java.util.Scanner;

public class N10818 {

	/**
	 * 'N'개의 정수가 주어질 때 배열을 이용하여 최댓값과 최솟값 구하기
	 */

	public static void main(String[] args) {
		
		/**
		 * 'Scanner'를 이용하여 입력받을 정수의 개수 먼저 입력받음 (N)
		 * 길이가 'N'인 배열 선언
		 * 배열에 들어갈 'N'개의 정수를 입력받음
		 * 'Arrays.sort()'메소드를 통해 최솟값과 최댓값 구하기
		 */

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		System.out.println(arr[0] + " " + arr[N - 1]);
	}
}