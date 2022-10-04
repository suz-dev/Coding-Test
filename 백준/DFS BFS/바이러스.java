package BOJ_RE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {

	static int N, K, cnt;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 컴퓨터의 수
		K = sc.nextInt(); // 네트워크 상에서 직접 연결된 컴퓨터 쌍의 수

		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a][b] = adj[b][a] = 1; // 연결 표시
		}

		cnt = 0; // 1은 포함 X
		bfs();

		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visited[1] = true;
		q.add(1);

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int c = 1; c <= N; c++) {
				if (adj[curr][c] == 1 && !visited[c]) {
					visited[c] = true;
					q.add(c);
					cnt++;
				}
			}
		}
	}
}
