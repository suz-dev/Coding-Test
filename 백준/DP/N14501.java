import java.io.BufferedReader;
import java.io.InputStreamReader;

// 퇴사 (DP)
public class N14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 2];

		String[] str;
		for (int i = 1; i <= N; i++) {
			str = br.readLine().split(" ");
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
		}

		for (int i = N; i > 0; i--) {
			// dp[i + T[i]] > N+1 경우, i 날짜에 일 시작 X
			if (i + T[i] > N + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
			}
		}
		System.out.println(dp[1]);
	}
}