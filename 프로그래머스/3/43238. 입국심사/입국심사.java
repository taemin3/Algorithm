import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int k = times.length;
        
        Arrays.sort(times);
        
        long low = 0;
        long high = (long) times[k - 1] * n;
        
        while(low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (int i = 0 ; i < k ; i++) {
                count += mid / times[i];                             
            }
            if (count < n) { 
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
    
    
}