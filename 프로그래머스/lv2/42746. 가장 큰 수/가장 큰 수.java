import java.util.*;

class Solution {
    
    public static String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = numbers[i] + "";
        }
        
        Arrays.sort(arr, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        if(arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        
        answer = sb.toString();
    
        return answer;
    }
}