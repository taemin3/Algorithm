import java.util.*;

class Solution {
    
    List<int[]>[] graph;
  
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < fares.length;i++) {
            int p = fares[i][0];
            int q = fares[i][1];
            int w = fares[i][2];
            graph[p].add(new int[]{q,w});
            graph[q].add(new int[]{p,w});
        }
        int [] result1 = dijk(n,s);
        int [] result2 = dijk(n,a);
        int [] result3 = dijk(n,b);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n;i++) {
            min = Math.min(min, result1[i] + result2[i] + result3[i]);
        }
        return min;
        
    }
    
    public int[] dijk(int n, int s) {
        int [] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]); 
        pq.offer(new int[]{s,0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (cost != dist[now]) continue;
            for (int [] g : graph[now]) {
                if (cost + g[1] >= dist[g[0]]) continue;
                dist[g[0]] = cost + g[1];
                pq.offer(new int[]{g[0],cost+g[1]});
            }
        }
        return dist;
    }
    
  

}