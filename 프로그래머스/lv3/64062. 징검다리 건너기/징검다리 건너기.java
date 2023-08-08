class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 1;
        int max = 200000000;
        
        while(min <= max){
            int mid = (min + max) / 2;
            
            if(canAcross(stones, k, mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid); // 최댓값 갱신
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    public static boolean canAcross(int[] stones, int k, int mid){
        int passStone = 0;
        
        for(int stone : stones){
            if(stone - mid < 0) {
                passStone++;
            }else{
                passStone = 0;
            }
            
            if(passStone == k) return false;    // 못건넘
        }
        
        return true;
    }
}
