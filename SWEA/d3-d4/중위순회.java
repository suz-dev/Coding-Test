package d3_d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중위순회 {
	static int N;
	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				String num = st.nextToken(); // 노드 번호
				String str = st.nextToken(); // 요소
				char c = str.charAt(0);

				arr[i] = c;
			}
			System.out.print("#" + t + " ");
			traverse(1);
			System.out.println();
		}
	}

	public static void traverse(int idx) { // 트리배열에서의 idx

		// 기저조건
		if (idx > N)
			return;

		// 유도
		traverse(idx * 2);// 1. 왼쪽 먼저 탐색
		System.out.print(arr[idx]);// 2. 자기자신
		traverse(idx * 2 + 1);// 3. 오른쪽 자식 탐색
	}
}