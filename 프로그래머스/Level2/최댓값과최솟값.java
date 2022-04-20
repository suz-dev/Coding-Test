package Level2;

public class 최댓값과최솟값 {
	public String solution(String s) {
		String[] str = s.split(" ");

		int min = Integer.parseInt(str[0]);
		int max = Integer.parseInt(str[0]);

		for (String i : str) {
			min = Math.min(min, Integer.parseInt(i));
			max = Math.max(max, Integer.parseInt(i));
		}

		String answer = Integer.toString(min) + " " + Integer.toString(max);

		return answer;
	}
}