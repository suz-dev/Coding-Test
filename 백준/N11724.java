import java.util.Scanner;

/*
 * dfs
 */
public class N11724 {

	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int[][] adj; // 인접 행렬

	static boolean[] visit; // 방문 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		adj = new int[N + 1][N + 1];

		// 인접행렬 입력
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt(); // 시작점
			int v = sc.nextInt(); // 끝점

			// 무향간선이기 때문에 양방향 연결
			adj[u][v] = 1;
			adj[v][u] = 1;
		}

		visit = new boolean[N + 1];

		int cnt = 0; // 연결요소 개수

		// 방문 배열을 돌면서 방문하지 않은 정점에 대해 탐색 후 연결요소 개수1 증가
		for (int i = 1; i < N + 1; i++) {
			if (!visit[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	public static void dfs(int start) {

		visit[start] = true;

		for (int i = 1; i < N + 1; i++) {
			if (adj[start][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}

}
