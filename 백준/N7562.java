import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7562 {

	static int N; // 체스판 한변의 길이

	static int[][] chess;
	static boolean[][] visited;

	// 나이트 이동 좌표 - 8방향 탐색
	static int[] dx = { 1, 2, -2, -1, -2, -1, 1, 2 };
	static int[] dy = { 2, 1, 1, 2, -1, -2, -2, -1 };

	static int startX, startY, endX, endY;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // TC 개수

		// 테스트 한개 입력 루프
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			chess = new int[N][N];
			visited = new boolean[N][N];

			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();

			bfs(new Point(startX, startY));
			System.out.println(chess[endX][endY]);
		}

	}

	public static void bfs(Point point) {

		Queue<Point> que = new LinkedList<Point>();
		que.add(point);
		visited[point.x][point.y] = true;

		while (!que.isEmpty()) {
			Point p = que.poll();

			// 시작 지점 = 목표지점
			if (p.x == endX && p.y == endY) {
				return;
			}

			for (int i = 0; i < 8; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < N && cy < N && !visited[cx][cy]) {
					que.add(new Point(cx, cy));
					visited[cx][cy] = true;
					chess[cx][cy] = chess[p.x][p.y] + 1; // 이동 횟수
				}

			}

		}

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
