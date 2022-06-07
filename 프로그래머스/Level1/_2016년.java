package Level1;

public class _2016년 {
	public String solution(int a, int b) {
		String answer = "";

		int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };

		int allDate = 0;
		for (int i = 0; i < a - 1; i++) {
			allDate += date[i];
		}
		allDate += b;

		answer = day[allDate % 7];

		return answer;
	}
}