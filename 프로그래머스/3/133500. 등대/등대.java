import java.util.*;
class Solution {
    
    static List<Integer>[] graph;
    static boolean [] visit;
    static int [][] dp;
     
    public int solution(int n, int[][] lighthouse) {
        
        graph = new ArrayList[n+1];
        for (int i = 1;i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];
        
        for (int i = 0; i < n - 1;i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        dp = new int[n+1][2];
        dfs(1);
        return Math.min(dp[1][0],dp[1][1]);
        
    }
    
    public void dfs(int u) {
        visit[u] = true;
        dp[u][0] = 0;
        dp[u][1] = 1;
        for (int g : graph[u]) {
            if (!visit[g]) {
                dfs(g);
                dp[u][0] += dp[g][1];
                dp[u][1] += Math.min(dp[g][0],dp[g][1]);
            }
            
        } 
        
    }
    
}
    
    
    
    