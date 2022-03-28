package Sort;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 입력
 * - 배열 array
 * - 조건 [i,j,k]를 원소로 가진 이차원 배열 commands
 * 
 * 동작
 * - 배열 array에 대해 command로 입력받은 [i,j,k]를 실행한다
 * 1) array에서 i~j번째 수 뽑기
 * 2) 뽑아낸 i~j 사이의 수 오름차순 정렬
 * 3) 2의 k번째 수 뽑기
 * 
 * 출력
 * - 배열 array에서 commands의 원소를 모두 실행한 결과 배열로 출력
 */
public class K번째수 {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int a = 0; a < commands.length; a++) {

			ArrayList<Integer> list = new ArrayList<Integer>();

			int i = commands[a][0];
			int j = commands[a][1];
			int k = commands[a][2];

			for (int b = i - 1; b < j; b++) {
				list.add(array[b]);
			}

			Collections.sort(list);

			answer[a] = list.get(k - 1);

		}

		return answer;
	}
}