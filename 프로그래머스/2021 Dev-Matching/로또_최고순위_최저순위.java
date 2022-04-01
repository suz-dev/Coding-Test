
/*
 * 입력
 * - 숫자가 일부 지워진 로또 번호 배열 (지워진 숫자는 0으로 표시) : int[] lottos
 * - 당첨 로또 번호 : int[] win_nums
 * 
 * 동작
 * - lottos의 0이 아닌 요소와 win_nums의 요소 비교 : 같다면 zeroCnt + 1
 * - 0을 제외하고 비교했을때 일치하는 숫자의 개수 = min
 * - min + zeroCnt인 배열의 개수 = max
 * - switch case 문으로 등수 뽑기 (lottoRank)
 * 
 * 출력
 * - 최고등수와 최저등수를 각각 answer에 담아 return
 * 
 */
public class 로또_최고순위_최저순위 {

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		int zeroCnt = 0;
		int min = 0;
		for (int i : lottos) {
			if (i == 0) {
				zeroCnt++;
				continue;
			}
			for (int j : win_nums) {
				if (i == j)
					min++;
			}
		}

		answer[0] = lottoRank(zeroCnt + min);
		answer[1] = lottoRank(min);

		return answer;
	}

	public int lottoRank(int n) {
		switch (n) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
