import java.util.*;

class Solution {
    
    static int[] parent;
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a,int b) {
        int ra = find(a);
        int rb = find(b);
        
        if (ra == rb) return;
        parent[rb] = ra;
    }
    
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        int ans= 0 ;
        parent = new int[n +1];
        for (int i = 1; i <= n;i++) {
            parent[i] = i;
        }
        for (int i = 0 ; i < costs.length;i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0],costs[i][1]);
                ans += costs[i][2];
            }
        }
        return ans;
    }
}