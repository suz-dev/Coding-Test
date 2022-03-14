import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1260 {

	static int N; // 정점 개수
	static int M; // 간선 개수
	static int V; // 시작 정점
	static int[][] adj; // 인접 행렬
	static boolean[] visited; // 방문 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj[u][v] = adj[v][u] = 1;
		}

		dfs(V);
		visited = new boolean[N + 1]; // 방문배열 초기화
		System.out.println();
		bfs(V);

	}

	static void dfs(int start) {

		visited[start] = true;
		System.out.print(start + " ");

		// 1부터 시작
		for (int i = 1; i < N + 1; i++) {
			if (adj[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}

	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();

		visited[start] = true;
		que.add(start);

		while (!que.isEmpty()) {
			int curr = que.remove();
			System.out.print(curr + " ");

			// 1부터 시작
			for (int i = 1; i < N + 1; i++) {
				if (adj[curr][i] != 0 && !visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}

		}

	}

}
