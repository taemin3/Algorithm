import java.util.*;
class Solution {
    
    List<Integer>[] graph;
    boolean [] visit;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n;i++){
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[n+ 1];
        
        for (int [] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return bfs();
        
      
    }
    
    public int bfs() {
        visit[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});
        int cnt = 0;
        int max = 0;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];
            if (cost > max) {
                max = cost;
                cnt = 1;
            } else if (cost == max) {
                cnt++;
            }
            for (int g : graph[now]) {
                if (visit[g]) continue;
                visit[g] = true;
                q.offer(new int[]{g, cost + 1});
            }
        }
        return cnt;
    }
    
   
    
}