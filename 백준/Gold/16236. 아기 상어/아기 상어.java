import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int baby = 2;
    static int count = 0;
    static int time = 0;
    static int x, y;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            if (!bfs()) {
                break;
            }
        }
        System.out.println(time);
        
    }

    public static boolean check() {
        for (int i = 0 ; i < n;i++) {
            for (int j = 0 ; j < n;j++) {
                if (map[i][j] != 0 && map[i][j] < baby) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs() {
        visit = new boolean[n][n];
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            if (a[2] == b[2] &&a[0] == b[0]) return a[1] - b[1];
            else if (a[2] == b[2]) return a[0] - b[0]; 
            else return a[2] - b[2];
        });
        for (int i = 0 ; i < n;i++) {
            for (int j = 0 ; j <n;j++) {
                
                if (map[i][j] == 9)  {
                    visit[i][j] = true;
                    q.offer(new int[]{i,j,0});
                    map[i][j] = 0;
                }
                
            }
        }
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            if (map[x][y] != 0 && map[x][y] != 9 && map[x][y] < baby) {
                time += w;
                count++;
                if (count == baby) {
                    count = 0;
                    baby++;
                } 
                
                map[x][y] = 9;
                return true;
            }
            for (int i = 0 ; i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] <= baby) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx,ny, w + 1});
                }
                    
                
            }
        }
        return false;
        
        
    }

    

    
}