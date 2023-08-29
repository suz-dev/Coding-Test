import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        int day = 1;
        int idx = 0;

        while (true) {
            int cnt = 0;

            if (progresses[idx] + (speeds[idx] * day) >= 100) {
                cnt++;
                idx++;

                for (int i = idx; i < progresses.length; i++) {
                    if (progresses[i] + (speeds[i] * day) >= 100) {
                        idx++;
                        cnt++;
                    } else {
                        break;
                    }
                }

                answer.add(cnt);
                if (idx >= progresses.length) {
                    break;
                }
            } else {
                day++;
            }
        }
        return answer;
    }
}
