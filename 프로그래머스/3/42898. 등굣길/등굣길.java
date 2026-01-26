import java.util.*;
class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int [][] dp = new int[m + 1][n + 1];
        boolean [][] visit = new boolean[m+1][n+1];
        
        dp[1][1] = 1;
        visit[1][1] = true;
        for (int i = 0 ; i < puddles.length;i++) {
            visit[puddles[i][0]][puddles[i][1]] = true;
        }
        
        for (int i = 1; i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (!visit[i][j]) {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
                }
            }
        }
        return dp[m][n];
        
    }
    
    
}