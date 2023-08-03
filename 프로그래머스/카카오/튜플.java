package PRGRMS.kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class 튜플 {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();

        s = s.substring(2, s.length());
        s = s.substring(0, s.length() - 2).replace("},{", " ");

        String str[] = s.split(" ");
        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());    //  원소 길이로 오름차순 정렬

        for (String x : str) {
            String[] temp = x.split(",");
            for (int i = 0; i < temp.length; i++) {
                int n = Integer.parseInt(temp[i]);
                if (!answer.contains(n)) answer.add(n);
            }
        }

        return answer;
    }
}