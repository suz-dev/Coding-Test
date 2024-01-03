import java.util.*;

class Solution {    
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        PriorityQueue<File> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.head.equals(o2.head)){
                if(o1.num == o2.num) return o1.idx - o2.idx;
                return o1.num - o2.num;
            }
            return o1.head.compareTo(o2.head);
        });
        
        for(int i = 0; i < files.length; i++){
            String file = files[i];
            
            // head, tail 나누기
            String tmpFile = file.replaceAll("[0-9]", "@");
            String[] tmp = tmpFile.split("@+"); // head, tail        
            
            // number 추출
            String number = file.substring(tmp[0].length());  // head 이후부터 check
            String[] num = number.replaceAll("[a-zA-Z.-]", " ").split(" ");  // 숫자가 아닌 부분 공백으로 대체 && split
            int n = Integer.parseInt(num[0]);   // int 로 변환
            
            // idx, head, num
            File now = new File(i, tmp[0].toUpperCase(), n);
            pq.add(now);
        }
        
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = files[pq.poll().idx];
        }
        
        return answer;
    }
    
    static class File {
        int idx, num;
        String head;
        
        public File(int idx, String head, int num){
            this.idx = idx;
            this.head = head;
            this.num = num;
        }
    }
}

