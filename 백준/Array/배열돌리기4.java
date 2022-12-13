package 배열특공대;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 배열돌리기4 {

	static int N, M, K;

	static int[][] arr, copy;

	static int[][] op, tmp;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;

	// 시계방향으로 한칸씩 회전
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt(); // 회전 연산의 개수 1<= K <=6 : 연산 순서에 따라 결과가 달라짐 최소값을 구해라

		// 배열 입력
		arr = new int[N + 1][M + 1];
		copy = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 연산 입력 -> 순열로 배열 케이스 생성
		op = new int[K][3];
		tmp = new int[K][3];
		isSelected = new boolean[K];
		for (int i = 0; i < K; i++) {
			op[i][0] = sc.nextInt(); // r
			op[i][1] = sc.nextInt(); // c
			op[i][2] = sc.nextInt(); // s
		}

		Permutation(0);
		System.out.println(min);
	}

	static void Permutation(int cnt) {
		if (cnt == K) { // 새로운 순열 생성 (이 순서로 rotation 실행?)
			rotation();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!isSelected[i]) {
				tmp[cnt] = op[i];

				isSelected[i] = true;
				Permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	static void rotation() {

		copy(); // 카피 수행

		for (int i = 0; i < K; i++) { // 수행할 연산 횟수

			int[] tmpOp = tmp[i]; // 연산 조건
			int r = tmpOp[0];
			int c = tmpOp[1];
			int s = tmpOp[2];

			int startR = r - s;
			int startC = c - s;
			int endR = r + s;
			int endC = c + s;

			while (startR <= endR && startC <= endC) {
				Queue<Integer> q = new LinkedList<>();

				int dir = 1; // 우하좌상

				switch (dir) {
				case 1: // 우
					for (int d = startC; d <= endC; d++) {
						q.add(copy[startR][d]);
						if (d > startC) {
							copy[startR][d] = q.poll(); // 이전값 넣기
						}
					}

					dir = 2;
					break;
				case 2: // 하
					for (int d = startR + 1; d <= endR; d++) {
						q.add(copy[d][endC]);
						copy[d][endC] = q.poll(); // 이전값 넣기
					}

					dir = 3;
					break;
				case 3: // 좌
					for (int d = endC - 1; d >= startC; d--) {
						q.add(copy[endR][d]);
						copy[endR][d] = q.poll(); // 이전값 넣기
					}

					dir = 4;
					break;
				case 4: // 상
					for (int d = endR - 1; d >= startR; d--) {
						q.add(copy[d][startC]);
						copy[d][startC] = q.poll(); // 이전값 넣기
					}

					dir = 1;

					startR++;
					startC++;
					endR--;
					endC--;

					break;
				}
			}
		}
		findMin();
	}

	static void findMin() { // 해당 case에서 연산 모두 수행 후 최소값

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += copy[i][j];
			}
			if (min > sum)
				min = sum;
		}
	}

	static void copy() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	// 확인용
	static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(copy[i] + " ");
			}
			System.out.println();
		}
	}
}
