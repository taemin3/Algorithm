import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int ans = 0;
    static boolean [][] visit;
    static char [][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visit = new boolean[5][5];
        map = new char[5][5];
        for (int i = 0 ; i < 5;i++) {
            String str = br.readLine();
            for (int j = 0; j < 5;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(0,0,0);
        System.out.println(ans);
    }

    static void dfs(int depth, int idx, int yCnt) {
        if (yCnt >= 4) {
            return;
        }

        if (depth == 7) {
            
            if(bfs((idx -1) / 5,(idx - 1) % 5)) {
                ans++;
            }
            return;
        }

        
        for (int i = idx; i < 25;i++) {
            
            int x = i / 5;
            int y = i % 5;
            visit[x][y] = true;
            if (map[x][y] == 'Y') {
                dfs(depth+1,i + 1,yCnt + 1);
            } else {
                dfs(depth+1,i + 1,yCnt);
            }
            visit[x][y] = false;
        }
    }

    static boolean bfs(int x,int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        boolean [][] visit2 = new boolean[5][5];
        visit2[x][y] = true;
        
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        int cnt = 1;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i =0;i < 4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visit2[nx][ny]) continue;
                if (!visit[nx][ny]) continue;
                cnt++;
                visit2[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
        if (cnt == 7) return true;
        return false;
    }
}