import java.util.*;

class Solution {
    
    static List<int[]>[] graph;
    static int INF = 1_000_000_000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 1;i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] f :fares) {
            int x = f[0];
            int y = f[1];
            int c = f[2];
            
            graph[x].add(new int[]{y,c});
            graph[y].add(new int[]{x,c});
        }
        int [] distA = dijk(a, n);
        int [] distB = dijk(b, n);
        int [] distS = dijk(s, n);
        long ans = Long.MAX_VALUE;
        
        for (int i = 1 ;i <= n;i++) {
            long sum = (long) distA[i] + distB[i] + distS[i];
            if (sum < ans) {
                ans = sum;
            }
        }
        return (int) ans;
    }
    
    static int[] dijk(int s, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist,INF);
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{s,0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (dist[now] != cost) continue;
            for (int [] g : graph[now]) {
                int w = g[1] + cost;
                if (w < dist[g[0]]) {
                    dist[g[0]] = w;
                    pq.offer(new int[]{g[0],w});
                }
            }
        }
        return dist;
    }

}