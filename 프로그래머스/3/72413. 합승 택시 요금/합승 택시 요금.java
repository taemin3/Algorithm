import java.util.*;

class Solution {
    
    List<int[]>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int [] f : fares) {
            int u = f[0];
            int v = f[1];
            int w = f[2];
            
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        
        int[] distS = dijk(s, n);
        int[] distA = dijk(a, n);
        int[] distB = dijk(b, n);
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n;i++) {
            int dist = distS[i] + distA[i] + distB[i];
            min  = Math.min(min,dist);
        }
        
        
        return min;
    }
    
    public int[] dijk(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (cost > dist[now]) continue;
            
            for (int [] g : graph[now]) {
                int next = g[0]; 
                int w = g[1];
                
                if (cost + w < dist[next]) {
                    dist[next] = w + cost;
                    pq.offer(new int[]{g[0], cost + w});
                }
            }
        }
        
        return dist;
    }
}