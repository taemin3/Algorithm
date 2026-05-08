import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int k = times.length;
        long lo = 1;
        long hi = (long) times[k - 1] * n;
        
        long ans = 0;
        
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            
            long cnt = 0;
            
            for (int t : times) {
                cnt += mid / t;
            }
            
            if (cnt >= n) {
                ans = mid;
                hi = mid - 1;
                
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
        
        
    }
}