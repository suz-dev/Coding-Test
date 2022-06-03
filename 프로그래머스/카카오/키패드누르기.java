package Kakao;

// 14, 17, 18, 19 실패 왜?
public class 키패드누르기 {

	static int[][] thumb = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
	static int[] left = { 3, 0 }; // *
	static int[] right = { 3, 2 }; // #

	public String solution(int[] numbers, String hand) {
		String answer = "";

		for (int i : numbers) {
			answer += keypad(i, hand);
		}

		return answer;
	}

	public String keypad(int a, String hand) {
		String k = "";

		for (int i = 0; i < thumb.length; i++) {
			for (int j = 0; j < thumb[i].length; j++) {

				if (thumb[i][j] == a) {

					if (a == 1 || a == 4 || a == 7) {
						left[0] = i;
						left[1] = j;
						k = "L";

					} else if (a == 3 || a == 6 || a == 9) {
						right[0] = i;
						right[1] = j;
						k = "R";

					} else {
						k += middleNum(i, j, hand);
					}
				}
			}
		}
		return k;
	}

	public String middleNum(int row, int column, String hand) {
		String k = "";

		// 손가락-숫자 거리
		int absL = Math.abs(row - left[0]) + Math.abs(column - left[1]);
		int absR = Math.abs(row - right[0]) + Math.abs(column - right[1]);

		System.out.print(absL + " " + absR);
		System.out.println();

		if (absL == absR) {
			k = Character.toString(hand.charAt(0)).toUpperCase();
		} else {
			k = absL < absR ? "L" : "R";
		}

		if (k == "L") {
			left[0] = row;
			left[1] = column;
		} else {
			right[0] = row;
			right[1] = column;
		}

		return k;
	}
}