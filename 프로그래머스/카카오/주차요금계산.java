package Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 테케3 통과
public class 주차요금계산 {

	public int[] solution(int[] fees, String[] records) {
		int lastTime = getMin("23:59");

		Map<String, Integer> parking = new HashMap<>();
		Map<String, Integer> times = new HashMap<>();
		ArrayList<String> cars = new ArrayList<String>();

		for (String record : records) {

			String[] rc = record.split(" "); // 시각, 차량번호, 내역(입출차)
			int time = getMin(rc[0]);
			String car = rc[1];

			// 새로운 차 목록
			if (!cars.contains(car)) {
				cars.add(car);
				times.put(car, 0);
			}

			if (parking.containsKey(car)) { // 출차
				times.put(car, times.get(car) + (time - parking.get(car)));
				parking.remove(car);
			} else { // 입차
				parking.put(car, time);
			}
		}

		int[] ret = new int[cars.size()];
		Collections.sort(cars);

		for (int i = 0; i < cars.size(); i++) {
			ret[i] = fees[1];
			String car = cars.get(i);

			int time = times.get(car) - fees[0];

			if (parking.containsKey(car))
				time += (lastTime - parking.get(car));
			if (time > 0)
				ret[i] += (Math.ceil(time / fees[2] * 1.0)) * fees[3];
		}

		return ret;
	}

	public int getMin(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
	}
}