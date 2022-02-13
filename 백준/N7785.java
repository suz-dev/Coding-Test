
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 입력
 * 직원 출퇴근 로그 수 - N
 * N번 만큼 (직원이름, enter/leave) 입력
 * 
 * 동작
 * HashMap 사용
 * - 퇴근로그를 찍는 경우 (이름, leave)입력 : (이름, enter)입력되어 있음 -> 기존 값 삭제
 * - 출근로그를 찍는 경우 새로 (이름, enter)입력
 * 
 * 출력
 * 이름을 알파벳 역순으로 출력해야 하므로 ArrayList에 key값 저장
 * Collections.reverseOrder()를 통해 역순 정렬
 * list 출력
 * 
 */
public class N7785 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			String name = sc.next();
			String stat = sc.next();

			if (map.containsKey(name)) {
				map.remove(name);
			} else {
				map.put(name, stat);
			}
		}

		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());

		for (String a : list) {
			System.out.print(a + " ");
		}

	}

}
