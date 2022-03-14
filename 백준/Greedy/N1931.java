import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] arr = new int[N][2];

		// 회의 입력받기
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // 시작 시간
			arr[i][1] = sc.nextInt(); // 종료 시간
		}

		// 종료 시간 기준으로 배열 정렬 (compare 재정의)
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				// 종료시간이 같은 경우 시작시간이 빠른순으로 정렬
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}
		});

		int cnt = 0;	// 회의 개수
		int prev_end_time = 0;	// 이전 회의 종료시간

		for (int i = 0; i < N; i++) {
			if (prev_end_time <= arr[i][0]) {
				prev_end_time = arr[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}
