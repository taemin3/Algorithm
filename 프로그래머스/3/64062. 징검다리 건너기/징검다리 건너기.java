class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for (int s : stones) {
            high = Math.max(high,s);
            low = Math.min(low,s);
        }
        
        while(low <= high) {
            int mid = (low + high) / 2;
            
            if (canCross(stones,k,mid)) {
                low = mid + 1;
            } else {
                high = mid - 1 ;
            }
            
            
        }
        
        
        return low;
    }
    
    public boolean canCross(int[] stones, int k , int num) {
        int count = 0 ;
        for (int i = 0 ; i < stones.length ; i++) {
            if (stones[i] - num <= 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                return false;
            }
        }
        return true;
    }
}