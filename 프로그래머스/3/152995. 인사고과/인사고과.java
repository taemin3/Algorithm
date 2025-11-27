import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int hoA = scores[0][0];
        int hoB = scores[0][1];
        
        
        
        Arrays.sort(scores, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        int rank = 1;
        int max = 0;
        
        for (int [] s :scores) {
            if (s[0] > hoA && s[1] > hoB) {
                return -1;
            }
            
            if (s[1] < max) continue;
            max = s[1];
            
            int sum = s[0] + s[1];
            if (hoA + hoB < sum) rank++;
         }
        
        return rank;
    }
}