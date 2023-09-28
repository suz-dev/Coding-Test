import java.util.*;

class Solution {
    
    public static int solution(String numbers) {
        int answer = 0;
        
        String[] arr = numbers.split("");
        int[] nums = new int[10];
        for(int i = 0; i < arr.length; i++){
            nums[Integer.parseInt(arr[i])]++;
        }
        
        for(int i = 2; i < 10000000; i++){
            if(isPrime(i) && isContains(nums, i)){
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean isPrime(int num){
        if(num == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    public static boolean isContains(int[] nums, int k){
        int[] tmp = nums.clone();
        
        while(k > 0){
            if(tmp[k % 10] == 0) return false;
            
            tmp[k % 10]--;
            k /= 10;
        }
    
        return true;
    }
}