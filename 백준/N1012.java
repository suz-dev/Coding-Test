import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1012 {

	static int M; // 배추밭 가로
	static int N; // 배추밭 세로
	static int K; // 배추가 심어진 위치의 개수

	static int[][] adj; // 배추밭
	static boolean[][] visited; // 방문 체크

	static int[] dx = { 1, -1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // TC 개수

		for (int t = 0; t < T; t++) {

			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			adj = new int[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				int x = sc.nextInt(); // 배추 위치 x좌표
				int y = sc.nextInt(); // 배추 위치 y좌표

				adj[x][y] = 1;
			}

			int cnt = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}

	}

	static void bfs(int x, int y) {

		// Queue에 배열로 좌표 넣기
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { x, y });

		while (!que.isEmpty()) {

			x = que.peek()[0];
			y = que.peek()[1];

			visited[x][y] = true;
			que.poll();

			// 4방면 탐색
			for (int i = 0; i < 4; i++) {

				// 좌표
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					// 배추 o && 방문 x
					if (adj[cx][cy] == 1 && !visited[cx][cy]) {
						visited[cx][cy] = true;
						que.add(new int[] { cx, cy });
					}
				}
			}

		}

	}

}
