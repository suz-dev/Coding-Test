import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
public class N1743 {

	static int N, M, K; // 통로 가로, 세로, 음식물 개수

	// 상하좌우
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int[][] trash;
	static boolean[][] visited;

	static int max, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		trash = new int[N][M];
		visited = new boolean[N][M];

		// 배열 채우기
		for (int i = 0; i < K; i++) {
			int R = sc.nextInt(); // x좌표
			int C = sc.nextInt(); // y좌표

			trash[R - 1][C - 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (trash[i][j] == 1 && !visited[i][j]) {
					cnt = 0; // 초기화
					bfs(i, j);
					max = Math.max(max, cnt);
				}
			}
		}

		System.out.println(max);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { x, y }); // 시작 좌표
		visited[x][y] = true;
		cnt++;

		while (!que.isEmpty()) {

			int[] Now = que.poll();
			int nowX = Now[0];
			int nowY = Now[1];

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int cx = nowX + dx[i];
				int cy = nowY + dy[i];

				if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
					if (!visited[cx][cy] && trash[cx][cy] == 1) {
						visited[cx][cy] = true;
						que.add(new int[] { cx, cy });
						cnt++;
					}
				}

			}

		}

	}

}
