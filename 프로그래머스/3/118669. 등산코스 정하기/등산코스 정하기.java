import java.util.*;
class Solution {
    
    static List<int[]>[] graph;
    static boolean[] isGate;
    static boolean[] isSummit;
    static int INF = 1_000_000_000;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        isGate = new boolean[n+1];
        isSummit = new boolean[n+1];
        
        for (int g : gates) {
            isGate[g] = true;
        }
        
        for (int s : summits) {
            isSummit[s] = true;
        }
        
        for (int [] p : paths) {
            int a = p[0];
            int b = p[1];
            int c = p[2];
            
            if (isGate[a] || isSummit[b]) {
                graph[a].add(new int[]{b,c});
            } else if (isGate[b] || isSummit[a]) {
                graph[b].add(new int[]{a,c});
            } else {
                graph[a].add(new int[]{b,c});
                graph[b].add(new int[]{a,c});
            }
        }
        return dijk(n);
        
    }
    
    public int[] dijk(int n) {
        int ans1 = 0;
        int ans2 = 1_000_000_000;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int i = 1; i <= n;i++) {
            if (isGate[i]) {
                dist[i] = 0;
                pq.offer(new int[]{i , 0});
            }
        }
        
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (dist[now] != cost) continue;
            if (isSummit[now]) continue;
            
            for (int [] g : graph[now]) {
                int max = Math.max(cost, g[1]);
                if (max < dist[g[0]]){
                    dist[g[0]] = max;
                    pq.offer(new int[]{g[0],max});
                }
            }
        }
        for (int i =1 ;i <= n;i++) {
            if(isSummit[i] && dist[i] < ans2) {
                ans1 = i;
                ans2 = dist[i];
            }
        }
        return new int[]{ans1,ans2};
    }
}