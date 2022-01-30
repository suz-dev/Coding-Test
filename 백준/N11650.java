
import java.util.Arrays;
import java.util.Scanner;

/*
 * int N 입력 - Scanner 사용
 * 점 2개 (x, y) N번 입력 - 2차원 배열
 * N개의 좌표 정렬  - 우선순위 : x > y (오름차순) -> Comparator 사용
 */
public class N11650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // x좌표 위치
			arr[i][1] = sc.nextInt(); // y좌표 위치
		}

		// Comparator (람다 사용)
		Arrays.sort(arr, (o1, o2) -> {

			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}