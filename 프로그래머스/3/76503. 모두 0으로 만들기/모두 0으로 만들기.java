import java.util.*;
class Solution {
    List<Integer>[] graph;
    long [] val;
    long anw;
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        long sum = 0;
        for (int i = 0 ; i < n;i++) {
            sum += a[i];
        }
        if (sum != 0) return -1; 
        
        val = new long[n];
        
        graph = new ArrayList[n];
        for (int i = 0; i < n;i++) {
            graph[i] = new ArrayList<>();
            val[i] = a[i];
        }
        
        for (int [] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        anw = 0;
        dfs(0,-1);        
        return anw;
    }
    
    public void dfs(int cur, int par) {
        for (int i = 0 ; i < graph[cur].size() ;i++) {
            int next = graph[cur].get(i);
            if (next == par) continue;
            dfs(next, cur);
            
            anw += Math.abs(val[next]);
            
            val[cur] += val[next];
            
        }
    }
}