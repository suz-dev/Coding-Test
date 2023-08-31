import java.util.*;

class Solution {
    
    static int n, ans;
    static boolean[] isSelected;
    
    public int solution(int[] numbers, int target) {        
        ans = 0;
        n = numbers.length;
        
        isSelected = new boolean[n];
        subSet(numbers, target, 0,0);
        
        return ans;
    }
    
    public static void subSet(int[] numbers,int target, int start, int cnt){
        if(start == n){
            if(calculate(numbers, target)) ans++;
            return;
        }
        
        isSelected[start] = true;
        subSet(numbers, target, start+1, cnt+1);
        
        isSelected[start] = false;
        subSet(numbers, target, start+1, cnt+1);
        
    }
    
    public static boolean calculate(int[] numbers, int target){
        int sum = 0;
        
        for(int i = 0;i < n; i++){
            if(isSelected[i]) sum += numbers[i];
            else sum -= numbers[i];
        }
        
        if(sum == target) return true;
        return false;
    }
}