import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        
        boolean [] isGate = new boolean[n + 1];
        boolean [] isSummit = new boolean[n+ 1];
        
        for(int g :gates) {
            isGate[g] = true;
        }
        
        for (int s : summits) {
            isSummit[s] = true;
        }
        
        List<int[]>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int [] p : paths) {
            int a = p[0];
            int b = p[1];
            int w = p[2];
            
            if (isGate[a] || isSummit[b]) {
                graph[a].add(new int[]{b,w});
            } else if (isGate[b] || isSummit[a]) {
                graph[b].add(new int[]{a,w});
            } else {
                graph[a].add(new int[]{b,w});
                graph[b].add(new int[]{a,w});
            }
        }    
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for (int g : gates) {
            pq.offer(new int[]{g,0});
        }
        
        while(!pq.isEmpty()) {
             int [] cur = pq.poll();
            
            if (cur[1] > dist[cur[0]]) continue;
            
            if (isSummit[cur[0]]) {
                continue;
            }
            
            for (int[] g : graph[cur[0]]) {
                int max = Math.max(cur[1],g[1]);
                if (max < dist[g[0]]) {
                    dist[g[0]] = max;
                    pq.offer(new int[]{g[0], max});
                }
            }
        }
        int anw1 = -1;
        int anw2 = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        for (int s : summits) {
            if (dist[s] < anw2) {
                anw1 = s;
                anw2 = dist[s];
            }
        }
    
        return new int[]{anw1,anw2};
    }
}