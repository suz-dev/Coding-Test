import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2178 {

	static int N;
	static int M;
	static int[][] adj; // 미로
	static boolean[][] visited; // 방문

	// 상하좌우
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		adj = new int[N][M];
		visited = new boolean[N][M];

		// 미로 채우기
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				adj[i][j] = str.charAt(j) - '0';
			}
		}

		visited[0][0] = true;	// (0,0) 방문한 채로 시작 
		bfs(0, 0);
		System.out.println(adj[N - 1][M - 1]);

	}

	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { x, y });

		while (!que.isEmpty()) {
			int now[] = que.poll();
			int nowX = now[0];
			int nowY = now[1];

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int cx = nowX + dx[i];
				int cy = nowY + dy[i];

				// 범위 설정
				if (cx >= 0 && cy >= 0 && cx < N && cy < M)
					// 이동가능 칸 && 방문 X
					if (adj[cx][cy] == 1 && !visited[cx][cy]) {
						que.add(new int[] { cx, cy });
						adj[cx][cy] = adj[nowX][nowY] + 1;	// 지나온 길에 대해 cnt++ 역할
						visited[cx][cy] = true;
					}
			}

		}

	}
}
