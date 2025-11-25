import java.util.*;
class Solution {
    
    List<int[]>[] graph;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        int [] array = dijk(1,N);
        int answer = 0 ;
        for (int i = 1; i <= N;i++) {
            System.out.println("i : " + array[i]);
            if (array[i] <= K) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public int[] dijk(int s, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[] {s,0});
        dist[s] = 0;
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            if (cost > dist[now]) continue;
            
            for (int[] g : graph[now]) {
                int nxt = g[0];
                int w = g[1];
                if (cost + w < dist[nxt]) {
                    dist[nxt] = cost + w;
                    pq.offer(new int[] {nxt, cost + w});
                }
            }
        }
        return dist;
        
    }
    
    
    

}