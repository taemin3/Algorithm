import java.util.*;
class Solution {
    public int solution(int[][] board) {
        
        return bfs(board);
    }
    
    public int bfs(int [][] board) {
        int min = Integer.MAX_VALUE;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        int n = board.length;
        
        if (n == 1) return 0;
        int [][][] dist = new int[n][n][4];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);
            }
        }
        
        for (int i = 0;i < 4;i++) {
            int nx = 0 + dx[i];
            int ny = 0 + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (board[nx][ny] == 1) continue;
            dist[nx][ny][i] = 100;
            q.offer(new int[] {nx,ny,i,100});
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];
            int cw = cur[3];
            
            if (cx == n - 1 && cy == n - 1) {
                min = Math.min(min, cw);
            }
            
            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = i;
                int nw;
                if (nd == cd) {
                    nw = cw + 100;
                } else {
                    nw = cw + 600;
                }
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] == 1 || nw >= dist[nx][ny][nd]) continue;
                q.offer(new int[]{nx,ny,nd,nw});
                dist[nx][ny][nd] = nw;
                
            }
        }
        return min;
    }
}