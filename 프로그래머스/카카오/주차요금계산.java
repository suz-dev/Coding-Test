package Kakao;

import java.util.ArrayList;
import java.util.HashMap;

// re
public class 주차요금계산 {

	public static HashMap<String, String> hashmap = new HashMap<String, String>();
	public static ArrayList<Integer> fee = new ArrayList<Integer>();

	public ArrayList<Integer> solution(int[] fees, String[] records) {

		String[] record = new String[3];
		for (int i = 0; i < records.length; i++) {

			record = records[i].split(" "); // 시각, 차량번호, 내역(입출차)

			if (!hashmap.containsKey(record[1])) { // 입차
				hashmap.put(record[1], record[0]); // 차량번호, 시각
			} else { // 출차
				parking(record[1], fees);
			}
		}

		if (!hashmap.isEmpty()) { // 입차만 있는 경우
			for (int i = 0; i < fee.size(); i++) {
				parking("23:59", fees);
			}
		}
		return fee;
	}

	public static void parking(String record, int[] fees) {

		String[] in = hashmap.get(hashmap.remove(record)).split(":"); // 입차시간(쓴거는 지우기)
		String[] out = record.split(":"); // 출차 시간:분

		int time = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
		int minute = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);

		int totalTime = time * 60 + minute;
		int addTime = totalTime - fees[0];

		if (totalTime <= fees[0]) {
			fee.add(fees[1]);
		} else {
			if (addTime % fees[3] == 0) {
				fee.add(fees[1] + (addTime / fees[3]) * fees[4]);
			} else {
				fee.add(fees[1] + (addTime / fees[3] + 1) * fees[4]);
			}
		}

	}
}