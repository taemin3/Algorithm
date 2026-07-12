import java.util.*;

class Solution {
    
    static boolean [][] visit;
    static int n, m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n + 1][m + 1];
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        visit[1][1] = true;
        q.offer(new int[]{1,1,1});

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cost = cur[2];
            if (cx == n && cy == m) {
                return cost;
            };
            
            for (int i = 0;i < 4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx <= 0 || nx > n || ny <= 0 || ny >m) continue;
                if (visit[nx][ny]) continue;
                if (maps[nx - 1][ny - 1] == 0) continue;
                visit[nx][ny] = true;
                q.offer(new int[]{nx,ny,cost+1});
            }
            
        }
        return -1; 
        
        
    }
   
    
}