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
            
            long count = 0;
            for (int t : times) {
                count += mid / t;
            
            }
            
            if (count >= n) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
        
        
    }
}