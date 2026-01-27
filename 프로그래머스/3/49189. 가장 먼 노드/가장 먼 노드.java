import java.util.*;
class Solution {
    
    static List<Integer>[] graph;
    static boolean [] visit;
    
   
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        for (int i = 1 ; i <= n;i++) {
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];
        
        for (int i = 0 ; i < edge.length;i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
            
        }
        
        return bfs();
    }
    
    public int bfs() {
        
        Queue<int[]> q = new LinkedList<>();
        visit[1] = true;
        q.offer(new int[]{1,0});
        int max = 0;
        int ans = 0;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int now = cur[0];
            int cnt = cur[1];
            if (cnt == max) {
                ans++;
            } else if (cnt > max) {
                max = cnt;
                ans = 1;
            }
            for (int g : graph[now]) {
                if (visit[g]) continue;
                visit[g] = true;
                q.offer(new int[] {g, cnt + 1});
            }
            
        }
        return ans;
    }
      
}