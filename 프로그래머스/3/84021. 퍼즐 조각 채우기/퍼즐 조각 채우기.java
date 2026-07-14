import java.util.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int n;
    public int solution(int[][] game_board, int[][] table) {
        
        n = game_board.length;
        List<List<int[]>> blank = extract(game_board,0); 
        List<List<int[]>> puzzle = extract(table,1); 
        boolean [] used = new boolean[puzzle.size()];
        int anw = 0;
        
        for (List<int[]> b : blank) {
            for (int i = 0 ; i < puzzle.size();i++){
                if (used[i]) continue;
                List<int[]> p = puzzle.get(i);
                for (int j = 0;j < 4;j++) {
                    if (check(b,p)) {
                        anw += p.size();
                        used[i] = true;
                        break;
                    }
                    p = rota(p);
                }
                if (used[i]) break;
                
                
                
            }
        }
        
        return anw;
    }
    
    public List<List<int[]>> extract(int[][] board,int target) {
        boolean [][] visit = new boolean[n][n];
        List<List<int[]>> shape = new ArrayList<>();
        for (int i = 0 ; i < n;i++) {
            for (int j = 0 ; j < n;j++) {
                if (board[i][j] == target && !visit[i][j]) {
                    List<int[]> rslt = bfs(board, visit,i,j,target);
                    shape.add(normal(rslt));
                }
            }
        }
        return shape;
    }
    
    public List<int[]> bfs (int[][] board,boolean[][] visit,int x, int y, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visit[x][y] = true;
        List<int[]> shape = new ArrayList<>();
        shape.add(new int[]{x,y});
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0 ; i < 4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!inRange(nx,ny)) continue;
                if (visit[nx][ny]) continue;
                if (board[nx][ny] != target) continue;
                visit[nx][ny] = true;
                shape.add(new int[]{nx,ny});
                q.offer(new int[]{nx,ny});
            } 
        }
        
        return shape;
    }
    public boolean inRange(int x,int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    
    public List<int[]> normal(List<int[]> shape) {
        List<int[]> nor = new ArrayList<>();
        int minX = 50;
        int minY = 50;
        
        for (int i = 0 ; i < shape.size();i++) {
            int[] arr = shape.get(i);
            minX = Math.min(minX,arr[0]);
            minY = Math.min(minY,arr[1]);
        }
        
        for (int i = 0 ; i < shape.size();i++) {
            int[] arr = shape.get(i);
            int nx = arr[0] - minX;
            int ny = arr[1] - minY;
            nor.add(new int[]{nx,ny});
        }
        
        nor.sort((a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        return nor;
        
    }
    
    public boolean check(List<int[]> blank, List<int[]> puzzle) {
        if (blank.size() != puzzle.size()) return false;
        
        for (int i = 0 ; i < blank.size();i++) {
            int [] p = puzzle.get(i);
            int [] b = blank.get(i);
            
            if (p[0] != b[0] || p[1] != b[1]) {
                return false;
            }
        }
        return true;
        
        
    }
    
    public List<int[]> rota(List<int[]> shape) {
        List<int[]> rota = new ArrayList<>();
        for (int [] s : shape) {
            rota.add(new int[]{s[1], s[0]* -1});
        }
        
        return normal(rota);
    }
        
}





