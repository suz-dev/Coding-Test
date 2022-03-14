import java.util.Scanner;

public class N1012 {

	static int M, N, K; // 가로, 세로, 배추 개수
	static int[][] adj; // 배추밭
	static boolean[][] visited; // 방문 체크

	// 상하좌우
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // TC 개수

		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			adj = new int[M][N];
			visited = new boolean[M][N];

			// 배추밭 채우기
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				adj[x][y] = 1;
			}

			int cnt = 0; // 배추흰나비

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}

	}

	static void dfs(int x, int y) {

		visited[x][y] = true;

		// 상하좌우 탐색
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) { // 추가 조건
				if (adj[cx][cy] == 1 && !visited[cx][cy]) {
					visited[cx][cy] = true;
					dfs(cx, cy);
				}
			}

		}

	}

}
