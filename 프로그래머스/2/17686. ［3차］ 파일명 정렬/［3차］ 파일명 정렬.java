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
            
            // head, number, tail 나누기
            String tmpFile = file.replaceAll("[0-9]", "@");
            String[] tmp = tmpFile.split("@+"); // head, tail
            
            int start = tmp[0].length();
        
            String number = file.substring(start);
            number = number.replaceAll("[a-zA-Z.-]", " ");
            String[] num = number.split(" ");
            int n = Integer.parseInt(num[0]);
            
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

