package Kakao;

public class 카카오프렌즈_컬러링북 {

	static int numberOfArea;
	static int maxSizeOfOneArea;

	static int cnt = 0;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public int[] solution(int m, int n, int[][] picture) {

		numberOfArea = 0;
		maxSizeOfOneArea = 0;
		int[] answer = new int[2];

		boolean[][] visit = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visit[i][j]) {
					numberOfArea++;
					dfs(i, j, picture, visit);
				}

				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
				cnt = 0;
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	public static void dfs(int x, int y, int[][] picture, boolean[][] visit) {

		if (visit[x][y])
			return;

		visit[x][y] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length)
				continue;

			if (picture[x][y] == picture[nx][ny] && !visit[nx][ny]) {
				dfs(nx, ny, picture, visit);
			}
		}
	}
}