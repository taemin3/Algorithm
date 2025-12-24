import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [][] map;
    static boolean [][] visit;
    static int n, m;
    static int anw = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(anw);
        
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            int a = bfs();
        
            anw = Math.max(a,anw);
            return;
        }
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
                
            }
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>(); 
        visit = new boolean[n][m];
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    visit[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i =0;i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visit[nx][ny] || map[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
        int count = 0;
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                   count++;
                }
            }
        }
        return count;
    }
}