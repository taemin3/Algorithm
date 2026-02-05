import java.util.*;
class Solution {
    
    static List<Integer>[] graph;
    static int [] dist;
 
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist,1_000_000_000);
        dist[1] = 0;
        for (int i = 1; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int [] e : edge) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return bfs(n);
    }
    public int bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});
        
        while(!q.isEmpty()) {
            
            int [] cur = q.poll();
            int now = cur[0];
            
            int cost = cur[1];
            
           
            if (dist[now] != cost) continue;
            for (int g : graph[now]) {
                
                if (cost + 1 < dist[g]) {
                    dist[g] = cost + 1;
                    q.offer(new int[]{g, cost + 1});
                }
            }
        }
        int max = 0;
    int cnt = 0;
    for (int i = 2;i <= n;i++) {
        if (dist[i] > max) {
            max = dist[i];
            cnt = 1;
        } else if (dist[i] == max) {
            cnt++;
        } 
    }
    return cnt;
    }
    
    
  
}