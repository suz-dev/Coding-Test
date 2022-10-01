package BOJ_RE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토가 익는데 걸리는 최소 날짜 구하기
public class 토마토 {

	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int M, N, day;
	static int[][] tomato;
	static int[][] drc = { { 0, 0, -1, 1 }, { -1, 1, 0, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		tomato = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tomato[i][j] = sc.nextInt();

		bfs();

		if (checkDone())
			System.out.println(day);
		else
			System.out.println(-1);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (tomato[i][j] == 1)
					q.add(new Node(i, j));

		while (!q.isEmpty()) {

			int T = q.size();
			for (int t = 0; t < T; t++) {
				Node node = q.poll();

				for (int d = 0; d < 4; d++) {
					int cx = node.r + drc[0][d];
					int cy = node.c + drc[1][d];

					if (cx >= 0 && cx < N && cy >= 0 && cy < M && tomato[cx][cy] == 0) {
						tomato[cx][cy] = 1;
						q.add(new Node(cx, cy));
					}
				}
			}
			day++;
		}
		day--; // 시작일 빼주기
	}

	public static boolean checkDone() {

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (tomato[i][j] == 0)
					return false;

		return true;
	}
}
