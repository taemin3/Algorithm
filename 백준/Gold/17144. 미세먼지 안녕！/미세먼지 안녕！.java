import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [][] map;
    static boolean [][] visit;
    static int r,c ,t;
    static int anw = 0;
    static int [] item;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0 ; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
            }
        }

        for (int i = 0; i < t; i++) {
            bfs();
        }
        int sum = 0;
         for (int i = 0 ; i < r; i++) {
            
            for (int j = 0 ; j < c; j++) {
                
               if (map[i][j] > 0) {
                   sum += map[i][j];
                   
               }
                
            }
            
        }
        System.out.println(sum);
        
    }

    public static void bfs() {
       Queue<int []> q = new LinkedList<>();
        Queue<int []> q2 = new LinkedList<>();
       for (int i = 0 ; i < r; i++) {
            for (int j = 0 ; j < c; j++) {
                if (map[i][j] >= 5) {
                    q.offer(new int[]{i, j,map[i][j]});
                }
                if (map[i][j] == -1) q2.offer(new int[]{i,j});
            }
        }
        int [] up  = q2.poll();
        int [] down = q2.poll();
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            for (int i = 0 ; i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == -1) continue;
                map[nx][ny] += w/5;
                map[x][y] -= w/5;
            }
        }
        for (int i = up[0] - 1; i > 0 ; i--) {
            map[i][0] = map[i-1][0];
        }
        for (int j = 0; j < c - 1;j++) {
            map[0][j] = map[0][j + 1];
        }

        for (int i = 0; i < up[0];i++) {
            map[i][c - 1] = map[i + 1][c-1];
        }

        for (int j = c - 1; j > 1;j--) {
            map[up[0]][j] = map[up[0]][j - 1] ;
        }
        map[up[0]][1] = 0;

        for (int i = down[0] + 1; i < r - 1;i++) {
            map[i][0] = map[i+1][0];
        }

        for (int j = 0; j < c - 1;j++) {
            map[r - 1][j] = map[r-1][j+1]; 
        }

        for (int i = r - 1; i > down[0]; i--) {
            map[i][c - 1] = map[i - 1][c-1];
        }

        for (int j = c - 1;j > 1;j--) {
            map[down[0]][j] = map[down[0]][j - 1];
        }

        map[down[0]][1] = 0;
    }

    


}