import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 키, 몸무게 담을 2차원 배열
		int[][] arr = new int[N][2];

		String[] st;
		for (int i = 0; i < N; i++) {
			st = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(st[0]); // 키
			arr[i][1] = Integer.parseInt(st[1]); // 몸무게
		}

		for (int i = 0; i < N; i++) {
			int rank = 1; // rank 1에서 시작

			for (int j = 0; j < N; j++) {
				if (i == j) // 자기자신 제외
					continue;
				// 키 & 몸무게 둘 다 클 경우 덩치가 큰 것, i번째 사람이 j번째 사람보다 덩치가 작을 경우 rank++
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}

			// i의 rank값 출력
			System.out.print(rank + " ");
		}

	}

}
