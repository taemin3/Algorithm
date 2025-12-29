import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] check;
    static int cheese = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0 ; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if (map[i][j] == 1) cheese++;
            }
        }
        System.out.println(bfs());
        
        
    }

    public static int bfs() {
        int count = 0;
        while(true) {
             check = new boolean[n][m];
        int [][] touch = new int[n][m];
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        check[0][0] = true;

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0 ; i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (check[nx][ny]) continue;
                if (map[nx][ny] == 0) {
                    check[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                } else {
                    touch[nx][ny]++;
                }
            }
        }

        for (int i =0;i < n;i++) {
            for (int j = 0; j < m;j++) {
                if (touch[i][j] >= 2) {
                    map[i][j] = 0; 
                    cheese--;
                }
            }
        }
            count++;
            if (cheese == 0) break;
            
        }
       return count;
    }
}