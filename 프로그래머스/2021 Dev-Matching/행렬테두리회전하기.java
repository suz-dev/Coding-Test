
public class 행렬테두리회전하기 {

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] nums = new int[rows][columns];
		int num = 1;

		// 행렬 rows x columns 채우기
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				nums[i][j] = num++;
			}
		}

		for (int i = 0; i < queries.length; i++) {

			int[] query = queries[i];
			int r1 = query[0] - 1, c1 = query[1] - 1, r2 = query[2] - 1, c2 = query[3] - 1;
			int tmp = nums[r1][c1]; // 시작값 (회전으로 덮어씌워질 값 미리 저장)
			int min = tmp; // 최소값

			// 왼쪽 테두리 회전
			for (int r = r1 + 1; r <= r2; r++) {
				min = Math.min(min, nums[r][c1]);
				nums[r - 1][c1] = nums[r][c1];
			}

			// 아래 테두리 회전
			for (int c = c1 + 1; c <= c2; c++) {
				min = Math.min(min, nums[r2][c]);
				nums[r2][c - 1] = nums[r2][c];
			}

			// 오른쪽 테두리 회전
			for (int r = r2 - 1; r >= r1; r--) {
				min = Math.min(min, nums[r][c2]);
				nums[r + 1][c2] = nums[r][c2];
			}
			// 윗 테두리 회전
			for (int c = c2 - 1; c > c1; c--) {
				min = Math.min(min, nums[r1][c]);
				nums[r1][c + 1] = nums[r1][c];
			}

			// 미리 빼놓은 nums[r1][c1]값 한 칸 뒤로 옮기기
			nums[r1][c1 + 1] = tmp;
			// 각 query의 최소값 저장
			answer[i] = min;
		}

		return answer;
	}

}
