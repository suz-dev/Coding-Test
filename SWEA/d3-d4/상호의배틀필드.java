package d3_d4;

import java.util.Scanner;

public class 상호의배틀필드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int H = sc.nextInt(); // 높이(행)
			int W = sc.nextInt(); // 넓이(열)

			// 전차 위치
			int r = 0;
			int c = 0;

			// map 채우기
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);

					// 전차 인덱스 찾기
					if (map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						r = i;
						c = j;
					}
				}
			}

			int N = sc.nextInt(); // 사용자가 넣을 입력 개수
			String strN = sc.next(); // 길이 N

			// 입력 검사 (U,D,L,R,S)
			for (int n = 0; n < N; n++) {

				char dir = strN.charAt(n);

				switch (dir) {
				case 'U':
					map[r][c] = '^'; // 전차 방향 바꾸기
					// 한 칸 위가 평지라면
					if (r > 0 && map[r - 1][c] == '.') {
						// 자리바꾸기
						map[r][c] = '.';
						r--;
						map[r][c] = '^';
					}
					break;
				case 'D':
					map[r][c] = 'v'; // 전차 방향 바꾸기
					// 한 칸 아래가 평지라면
					if (r < H - 1 && map[r + 1][c] == '.') {
						// 자리바꾸기
						map[r][c] = '.';
						r++;
						map[r][c] = 'v';
					}
					break;
				case 'L':
					map[r][c] = '<'; // 전차 방향 바꾸기
					// 한 칸 왼쪽이 평지라면
					if (c > 0 && map[r][c - 1] == '.') {
						// 자리바꾸기
						map[r][c] = '.';
						c--;
						map[r][c] = '<';
					}
					break;
				case 'R':
					map[r][c] = '>'; // 전차 방향 바꾸기
					// 한 칸 오른쪽이 평지라면
					if (c < W - 1 && map[r][c + 1] == '.') {
						// 자리바꾸기
						map[r][c] = '.';
						c++;
						map[r][c] = '>';
					}
					break;

				case 'S': // 포탄 발사 (map 인덱스 주의)
					if (map[r][c] == '^') {
						int tmp = r;
						while (tmp > 0 && map[tmp - 1][c] != '#') { // 한 칸 위가 강철벽이 아닐 때
							if (map[tmp - 1][c] == '*') { // 한 칸 위가 벽돌벽일 때
								map[tmp - 1][c] = '.'; // 평지로 만들고 break;
								break;
							} else { // 평지 or 물
								tmp--; // 포탄 계속 나아감
							}
						}

					} else if (map[r][c] == 'v') {

						int tmp = r;
						while (tmp < H - 1 && map[tmp + 1][c] != '#') {
							if (map[tmp + 1][c] == '*') {
								map[tmp + 1][c] = '.';
								break;
							} else {
								tmp++;
							}
						}

					} else if (map[r][c] == '<') {
						int tmp = c;
						while (tmp > 0 && map[r][tmp - 1] != '#') {
							if (map[r][tmp - 1] == '*') {
								map[r][tmp - 1] = '.';
								break;
							} else {
								tmp--;
							}
						}

					} else if (map[r][c] == '>') {
						int tmp = c;
						while (tmp < W - 1 && map[r][tmp + 1] != '#') {
							if (map[r][tmp + 1] == '*') {
								map[r][tmp + 1] = '.';
								break;
							} else {
								tmp++;
							}
						}
					}
				}
			}

			// 출력
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
}