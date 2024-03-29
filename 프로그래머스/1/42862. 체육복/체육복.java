public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;

		int[] locker = new int[n + 2];

		for (int i : lost) {
			locker[i]--; // -1
		}
		for (int i : reserve) {
			locker[i]++; // 1
		}

		for (int i = 1; i < locker.length - 1; i++) {

			if (locker[i] == -1) {
				if (locker[i - 1] == 1) {
					locker[i]++;
					locker[i - 1]--;
				} else if (locker[i + 1] == 1) {
					locker[i]++;
					locker[i + 1]--;
				}
			}
		}

		for (int i : locker) {
			if (i == -1) {
				answer--;
			}
		}

		return answer;
	}
}