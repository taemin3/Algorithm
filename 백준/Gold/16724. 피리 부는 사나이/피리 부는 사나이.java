import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static char [][] map;
    static int [][] state;
    static int N, M;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        state = new int[N][M];

        for (int i = 0 ; i < N;i++) {
            String str = br.readLine();
            for (int j = 0 ; j < M;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N;i++) {
            for (int j = 0 ; j < M; j++) {
                if (state[i][j] == 0) dfs(i,j);
            }
        }

        System.out.println(ans);

        
        
        
        
    }

    static void dfs(int x, int y) {
        state[x][y] = 1;
        int nx = x;
        int ny = y;
        if (map[x][y] == 'U') {
            nx = x - 1;
        } else if (map[x][y] == 'D') {
            nx = x + 1;
        } else if (map[x][y] == 'L') {
            ny = y - 1;
        } else {
            ny = y + 1;
        }

        if (state[nx][ny] == 0) {
            dfs(nx,ny);
        } else if (state[nx][ny] == 1)  {
            state[nx][ny] = 2;
            ans++;
        }
        state[x][y] = 2;
    }
}