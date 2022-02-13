import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 베스트셀러 - Map
 * 오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 
 * 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 데이터 구조 Map
 * 책 이름(key)
 * 입력횟수(value)
 * 총 팔린 책수 입력 (N) - BufferedReader
 * N만큼 책제목 입력
 * 
 * 동작
 * 같은 책 이름이 들어올 경우 key++
 * 
 * 출력
 * key값이 가장 큰 제목 출력
 */
public class N1302 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 책이름(key)-입력횟수(value)인 HashMap 생성
		HashMap<String, Integer> map = new HashMap<>();
		String str = new String(); // key값이 될 String

		for (int i = 0; i < N; i++) {
			str = br.readLine(); // key값 입력
			if (map.containsKey(str)) { // key값이 이미 map에 포함된 경우
				map.replace(str, map.get(str) + 1); // key값 + 1
			} else { // map에 포함되지 않은 경우
				map.put(str, 1);
			}

		}

		// 최대값 구하기
		int max = 0;
		for (String a : map.keySet()) { // key값의 개수 만큼 반복문 실행
			max = Math.max(max, map.get(a)); // 기존의 max값과 map의 키 값 비교
		}

		// 키값을 담을 배열 선언 후 오름차순 정렬
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list);

		// list 배열 조회
		for (String a : list) {
			if (map.get(a) == max) {
				System.out.println(a);
				break;
			}
		}

	}

}
