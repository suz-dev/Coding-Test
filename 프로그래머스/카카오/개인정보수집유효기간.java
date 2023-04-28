package 프로그래머스.카카오;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        String today ="2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(solution(today, terms, privacies));
    }
    public static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>(); // 파기해야할 개인정보 오름차순

        String[] ymd = today.split("\\.");  // 오늘 날짜
        // 오늘 날짜
        int year = Integer.parseInt(ymd[0]) -2000;
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);

        int days = (year * 28 * 12) + (month * 28) + day;

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] term = terms[i].split(" ");    // 약관종류, 유효기간
            map.put(term[0], term[1]);
        }

        for(int i =0; i< privacies.length; i++){
            String[] privacy = privacies[i].split(" "); // 가입날짜, 정책
            String[] privacyTerm = privacy[0].split("\\.");    // 가입날짜 분리

            // 정책 기간
            int policy = Integer.parseInt(map.get(privacy[1])) * 28;

            // 만료일 계산
            int expYear = Integer.parseInt(privacyTerm[0]) - 2000;
            int expMonth = Integer.parseInt(privacyTerm[1]);
            int expDay = Integer.parseInt(privacyTerm[2]);

            int expDays = (expYear * 28 * 12) + (expMonth * 28) + expDay;

            if(expDays + policy <= days){
                answer.add(i+1);
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
