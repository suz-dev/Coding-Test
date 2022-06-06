package Kakao;

class 키패드누르기 {
	public String solution(int[] numbers, String hand) {
		String answer = "";

		int left = 10;	// *
		int right = 12;	// #

		for (int i : numbers) {

			if (i == 0)
				i = 11;

			if (i == 1 || i == 4 || i == 7) {
				answer += "L";
				left = i;
			} else if (i == 3 || i == 6 || i == 9) {
				answer += "R";
				right = i;
			} else {

				// 왼-오 거리 비교
				int absL = Math.abs(left - i) / 3 + Math.abs(left - i) % 3;
				int absR = Math.abs(right - i) / 3 + Math.abs(right - i) % 3;
				
				if(absL < absR) {
					answer += "L";
					left = i;
				}else if(absL > absR) {
					answer += "R";
					right = i;
				}else {
					if(hand.equals("left")) {
						answer += "L";
						left = i;
					}else {
						answer += "R";
						right = i;
					}
				}

			}

		}

		return answer;
	}
}