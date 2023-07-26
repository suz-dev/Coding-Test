package PRGRMS.level3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;
        for(String operation : operations){
            st = new StringTokenizer(operation);

            // 입력값 분리
            String ops = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if(ops.equals("I")){    // 추가
                pq.add(value);
                reverse_pq.add(value);
            }else if(!pq.isEmpty()){    // 제거
                if(value < 0){  // 최솟값 제거
                    int min = pq.poll();
                    reverse_pq.remove(min);
                }else{  // 최대값 제거
                    int max = reverse_pq.poll();
                    pq.remove(max);
                }
            }
        }

        if(!pq.isEmpty() && !reverse_pq.isEmpty()){
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}