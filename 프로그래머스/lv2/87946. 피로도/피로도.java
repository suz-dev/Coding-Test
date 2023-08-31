import java.util.*;

class Solution {
    static int N, max = 0;
    
    static int[][] arr;
    static boolean[] isSelected;
    
    public static int solution(int k, int[][] dungeons) {        
        N = dungeons.length;
        
        arr = new int[N][2];
        isSelected = new boolean[N];
        
        permutation(0, k, dungeons);
        return max;
    }
    
    public static void permutation(int cnt, int k, int[][] dungeons){
        if(cnt == N) {
            int tmpK = k;
            int tmpCnt = 0;
            for(int i = 0; i< N; i++){                   
                if(adventure(tmpK,arr[i])){
                    tmpK -= arr[i][1];
                    tmpCnt++;
                }
            }
            
            max = Math.max(max, tmpCnt);            
            return;
        }
        
        for(int i = 0;i < N; i++){
            if(isSelected[i]) continue;
            
            arr[i] = dungeons[cnt];
            isSelected[i] = true;
            permutation(cnt+1, k, dungeons);
            isSelected[i] = false;
        }
    }
    
    public static boolean adventure(int tmpK, int[] arr){                
        if(arr[0] > tmpK) return false;
        return true;
    }
}