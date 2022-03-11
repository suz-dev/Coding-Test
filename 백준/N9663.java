
import java.util.Scanner;

public class N9663 {

	static int N;
	static int[] arr;
	static int cnt; // 경우의 수 count

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];

		dfs(0);
		System.out.println(cnt);
	}

	public static void dfs(int depth) {

		// 행을 다 채우면 cnt++ 후 리턴 (경우의 수 1 증가)
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i; // 검색하는 열

			if (Possibility(depth)) {
				dfs(depth + 1); // true가 return될 경우 다음 열 검사
			}

		}
	}

	// 해당 열에서 i번째 행에 Queen을 놓을 수 있는지 검사
	public static boolean Possibility(int col) {

		for (int i = 0; i < col; i++) {
			// 해당 열의 행과 i열의 행이 일치하는 경우 (같은 행에 존재)
			if (arr[col] == arr[i]) {
				return false;
			}

			// 대각선상에 놓여있는 경우
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;

	}

}
