import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int ans1 = 0;
        int ans2 = 0;
        int l = 0;
        int r = 0;
        int sum = sequence[r];
        int best = 1_000_000_000;
        
        while(l < n && r < n) {
            if (sum == k) {
                if (r - l + 1 < best) {
                    best = r - l + 1;
                    ans1 = l;
                    ans2 = r;
                }
                sum -= sequence[l++];
            } else if (sum > k) {
                sum -= sequence[l++];

            } else {
                r++;
                if (r >= n) break;
                sum += sequence[r];
            }
        } 
        return new int[]{ans1,ans2};
    }
}