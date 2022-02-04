package Array;

/*
 * x의 자릿수의 합으로 x가 나누어져야 합니다
 */
public class HarshardNum {

	public static boolean solution(int x) {
		boolean answer = true;
		String[] str = String.valueOf(x).split("");

		int sum = 0;

		for (String i : str) {
			sum += Integer.parseInt(i);
		}

		if (x % sum == 0) {
			answer = true;
		} else {
			answer = false;
		}

		return answer;
	}

}