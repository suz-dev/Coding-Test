package BOJ_RE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs
public class 스타트링크 {

	static int F, S, G, U, D, cnt;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		F = sc.nextInt(); // 꼭대기
		S = sc.nextInt(); // 시작
		G = sc.nextInt(); // 도착

		U = sc.nextInt(); // 위로 n칸
		D = sc.nextInt(); // 아래로 n칸

		cnt = 0;
		visited = new boolean[F + 1];

		bfs();

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited[S] = true;
		q.add(new int[] { S, cnt }); // 시작

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == G) {
				System.out.println(curr[1]);
				return;
			}

			int up = curr[0] + U;
			int down = curr[0] - D;

			if (up <= F && !visited[up]) {
				visited[up] = true;
				q.add(new int[] { up, curr[1] + 1 });

			}
			if (down > 0 && !visited[down]) {
				visited[down] = true;
				q.add(new int[] { down, curr[1] + 1 });
			}
		}
		System.out.println("use the stairs");
	}
}
