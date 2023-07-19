package PRGRMS.level3;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int L = triangle.length;
        int[][] dp = new int[L + 1][triangle[L - 1].length + 1];
        dp[1][1] = triangle[0][0]; // 초기화

        for (int r = 1; r <= L; r++) {
            for (int c = 1; c <= r; c++) {

                // 점화식
                dp[r][c] = Math.max((dp[r - 1][c - 1] + triangle[r - 1][c - 1]), (dp[r - 1][c] + triangle[r - 1][c - 1]));

                if (r == L) answer = Math.max(answer, dp[r][c]); // 마지막 행에서 최대값 갱신
            }
        }

        return answer;
    }
}
