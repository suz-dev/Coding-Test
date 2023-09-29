import java.util.*;

class Solution {
    
    static String Word;
    static char[] arr;
    static char[] words = {'A', 'E','I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    
    public static int solution(String word) {
        int answer = 0;
        
        for(int i = 1; i <= 5; i++){
            arr = new char[5];
            rePermutation(0, i);
        }
        
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                System.out.println(list.get(i));
                answer = (i+1);
            }
        }
        
        return answer;
    }
    
    public static void rePermutation(int cnt, int N){
        if(cnt == N){
            StringBuilder sb = new StringBuilder();
            for(char c : arr){
                sb.append(c);
            }
            
            list.add(sb.toString().trim());
            return;
        }
        
        for(int i = 0; i < 5; i++){
            arr[cnt] = words[i];
            rePermutation(cnt+1, N);
        }
    }
}