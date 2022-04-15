package Level1;

public class 최소직사각형 {
	public int solution(int[][] sizes) {

		int wMax = 0;
		int hMax = 0;

		for (int[] i : sizes) {
			wMax = Math.max(wMax, Math.max(i[0], i[1]));
			hMax = Math.max(hMax, Math.min(i[0], i[1]));
		}

		return wMax * hMax;
	}
}