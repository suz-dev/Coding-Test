package d1_d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1204_최빈수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[] scores = new int[101]; // 점수 : 0~100

			int n = Integer.parseInt(br.readLine()); // tc 번호
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				scores[score]++;
			}

			int max = 0;
			int maxcnt = 0;
			for (int i = 100; i >= 0; i--) {
				if (scores[i] > max) {
					max = scores[i];
					maxcnt = i;
				}
			}

			System.out.println("#" + n + " " + maxcnt);
		}
	}

}
