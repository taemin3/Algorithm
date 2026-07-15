import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int lo = 1;
        int hi = distance;
        int anw = 0;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int pre = 0;
            int cnt = 0;
            for (int rock : rocks) {
                if (rock - pre < mid) {
                    cnt++;
                } else {
                    pre = rock;
                }
            }
            if (distance - pre < mid) {
                cnt++;
            }
            
            if (cnt <= n) {
                anw = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            
        }
        
        return anw;
    }
    

}