import java.util.Arrays;
import java.util.Scanner;

/*
 * 수리공 항승
 * 
 * 입력 - Scanner 사용
 * 1. 물이 새는 곳 개수 N
 * 2. 테이프 길이 L
 * 3. 물이 새는 곳의 길이 배열에 저장
 * 
 * 동작
 * 1. 배열 정렬
 * 2. 먼저 붙인 테이프가 물 새는 곳을 얼만큼 막을 수 있는지 계산
 * 3. 물 새는 곳이 먼저 붙인 테이프로 막을 수 없는 지점일 경우 
 * - 테이프 개수 +1
 * - 새로운 테이프로 막을 수 있는 지점 재정의
 * 
 * 출력
 * 필요한 테이프 개수 출력
 */

public class N1449 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 물 새는 곳 개수
		int L = sc.nextInt(); // 테이프 길이

		int cnt = 1; // 테이프 개수

		double[] arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextDouble();
		}

		Arrays.sort(arr);
		double end = arr[0] - 0.5 + L; // 이전 테이프 끝나는 지점

		for (int i = 1; i < N; i++) {

			/*
			 * 이전에 붙인 테이프가 끝나는 지점을 넘을 경우 
			 * 1. 테이프 추가 
			 * 2. 끝나는 지점 재정의 (새로 붙인 테이프가 끝나는 지점)
			 */
			if (arr[i] + 0.5 > end) {
				cnt++;
				end = arr[i] - 0.5 + L;
			}
		}

		System.out.println(cnt);

	}

}
