import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * 입력
 * 직원 출퇴근 로그 수 - N
 * N번 만큼 (직원이름, enter/leave) 입력
 * 
 * 동작
 * HashSet 사용
 * String을 통해  name, status 입력받아 set에 저장할 요소 구분
 * - 퇴근로그를 찍는 경우 stat에 leave 입력 : 기존에 저장된 name 삭제
 * - 출근로그를 찍는 경우 stat에 enter 입력 : 새로운 name 저장
 * 
 * 출력
 * 이름을 알파벳 역순으로 출력해야 하므로 ArrayList에 set의 요소 저장 - Iterator(반복자) 사용
 * Collections.reverseOrder()를 통해 역순 정렬
 * BufferedWriter를 통해 list 출력
 */
public class N7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// HashSet을 통해 이름 저장
		HashSet<String> set = new HashSet<String>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" "); // split()으로 띄어쓰기 구분
			String name = input[0]; // 이름 입력
			String stat = input[1]; // 출퇴근 로그 입력

			/*
			 * 퇴근일 경우 - set에 저장된 이름 삭제 출근일 경우 - set에 이름 저장
			 */
			if (stat.equals("leave")) {
				set.remove(name);
			} else {
				set.add(name);
			}
		}

		/*
		 * set에 데이터가 있을 경우, 다음 데이터 list에 저장
		 */
		List<String> list = new ArrayList<String>();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}

		Collections.sort(list, Collections.reverseOrder());

		for (String name : list) {
			bw.write(name + "\n");
		}

		bw.flush();
	}

}
