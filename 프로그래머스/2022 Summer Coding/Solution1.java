// 히든테케 오류 (왜?)
public class Solution1 {

	public int solution(int[][] atmos) {
		int cnt = 0; // 마스크 개수

		int[] mask = new int[atmos.length]; // 마스크 사용 여부

		for (int i = 0; i < atmos.length; i++) {

			int a = atmos[i][0]; // 미세먼저 농도
			int b = atmos[i][1]; // 초미세먼지 농도

			if (a <= 81 && b <= 36) { // 나쁨 이하 (마스크 X)
				mask[i] = 0;
			} else if (a >= 151 && b >= 76) { // 매우나쁨 이상 (재사용 X)
				mask[i] = -1;
			} else { // 재사용 가능
				mask[i] = 1;
			}
		}

		// 재사용 여부 판단
		for (int i = 0; i < mask.length - 1; i++) {
			if (mask[i] == 1 && mask[i + 1] == 1 || mask[i] == 1 && mask[i + 1] == -1) {
				mask[i + 1] = 0;
			} else if (mask[i] == 1 && mask[i + 2] == 1 || mask[i] == 1 && mask[i + 2] == -1) {
				mask[i + 2] = 0;
			}
		}

		for (int i : mask) {
			if (i == 1 || i == -1) {
				cnt++;
			}
		}

		return cnt;
	}

}
