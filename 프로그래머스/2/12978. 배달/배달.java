import java.util.*;
class Solution {
    
    List<int[]>[] graph;
    int [] dist;
    int INF = 1_000_000_000;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist,INF);
        
        for (int i = 1; i <= N;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < road.length;i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }
        return dijk(K);
        
    }
    
    public int dijk(int k) {
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{1,0});
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (dist[now] != cost) continue;
            for (int [] g : graph[now]) {
                if (cost + g[1] < dist[g[0]]) {
                    dist[g[0]] = cost + g[1];
                    pq.offer(new int[]{g[0], cost + g[1]});
                }
            }
        }
        int count = 1;
        for (int i = 2 ; i < dist.length;i++) {
            if (dist[i] <= k) {
                count++;
            }
        }
        return count;
    }
    
    
    
    
    

}