import java.util.*;
class Solution {
    
    int[][] dp;
    boolean [] visit;
    List<Integer>[] graph;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        visit = new boolean[n + 1];
        dp = new int[n + 1][2];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n;i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] l : lighthouse) {
            graph[l[0]].add(l[1]);
            graph[l[1]].add(l[0]);
        }
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