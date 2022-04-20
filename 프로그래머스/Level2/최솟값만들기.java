package Level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기 {
	public Integer solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);

		Integer b[] = Arrays.stream(B).boxed().toArray(Integer[]::new);
		Arrays.sort(b, Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * b[i];
		}

		return (Integer)answer;
	}
}