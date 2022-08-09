package d3_d4;

import java.util.Arrays;
import java.util.Scanner;

public class N1208_Flatten {

	static int[] box;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int N = sc.nextInt(); // tc 개수

			// box 입력
			box = new int[100];
			for (int i = 0; i < box.length; i++) {
				box[i] = sc.nextInt();
			}

			// 초기 정렬
			Arrays.sort(box);

			// 최소값 + 1, 최대값 - 1, 재정렬
			for (int i = 0; i < N; i++) {
				box[0]++;
				box[box.length - 1]--;
				Arrays.sort(box);
			}

			// 출력
			System.out.println("#" + t + " " + (box[box.length - 1] - box[0]));
		}
	}
}
