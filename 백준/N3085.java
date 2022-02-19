import java.util.Scanner;

/*
 * 사탕게임
 * 
 * 입력 - Scanner 사용
 * 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
 * 다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다.(빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y)
 * 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
 * 
 * 동작
 * 사탕의 색이 다른 인접한 두 칸을 교환했을 때, 같은 색의 사탕이 연속으로 인접한 경우의 최대값 구하기
 * - 행이 같을 경우 (가로)
 * 1. 인접한 경우 cnt++
 * 2. 인접하지 않을 경우 cnt = 1
 * - 행이 다를 경우 (세로)
 * 1. 인접한 경우 cnt++
 * 2. 인접하지 않을 경우 cnt = 1
 * 
 * cnt가 max값 보다 클 경우 max = cnt
 * 
 * 출력
 * 같은 색의 사탕이 연속으로 인접한 경우의 최대값 출력 (max)
 */

public class N3085 {

	static int N;
	static char[][] arr;
	static int max = 0; // 최대값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];

		// 문자열을 입력받아 char로 저장
		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = st.charAt(j);
			}
		}

		/*
		 * 1. 인접한 두 사탕에 대한 문자 교환 
		 * 2. 최대값 찾기 
		 * 3. 교환했던 문자 원래 위치로 복구
		 */

		// 행이 같은 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				char tmp = arr[i][j];
				arr[i][j] = arr[i][j + 1];
				arr[i][j + 1] = tmp;

				check(arr);

				tmp = arr[i][j];
				arr[i][j] = arr[i][j + 1];
				arr[i][j + 1] = tmp;

			}
		}

		// 열이 같은 경우
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				char tmp = arr[j][i];
				arr[j][i] = arr[j + 1][i];
				arr[j + 1][i] = tmp;

				check(arr);

				tmp = arr[j][i];
				arr[j][i] = arr[j + 1][i];
				arr[j + 1][i] = tmp;

			}
		}
		
		// 최대값 출력
		System.out.println(max);
	}

	public static void check(char[][] arr) {

		// 행이 같을 경우 인접해 있는 사탕에 대한 최대값 찾기
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					cnt++;
				} else {
					cnt = 1;
				}

				max = Math.max(max, cnt);
			}

		}

		// 행이 다를 경우 인접해 있는 사탕에 대한 최대값 찾기
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}

				max = Math.max(max, cnt);
			}
		}
	}
}
