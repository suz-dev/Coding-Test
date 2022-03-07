import java.util.Scanner;

// dfs
public class N1987 {

	static int R, C;
	static int[][] adj;
	static boolean[] visited = new boolean[26];	// 각 알파벳에 대한 방문 check

	// 상하좌우 이동
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		adj = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				adj[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);
		System.out.println(max);

	}

	static void dfs(int x, int y, int cnt) {
		// 이미 방문한 알파벳인 경우
		if (visited[adj[x][y]]) {
			max = Math.max(max, cnt);
			return;
			
		// 방문하지 않은 경우
		} else {
			// 방문 check
			visited[adj[x][y]] = true;

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
					dfs(cx, cy, cnt + 1);
				}
			}

			// 다른 경로 탐색을 위해 방문배열 초기화 (미방문)
			visited[adj[x][y]] = false;
		}

	}

}
