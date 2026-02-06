import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static char [][] map;
    static boolean [] alpha;
    static int R, C;
    static int ans = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        alpha = new boolean[26];
        
        for (int i = 0; i < R;i++) {
            String str = br.readLine();
            for (int j = 0; j < C;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        char c = map[0][0];
        alpha[c - 'A'] = true;
        dfs(1,0,0);
        System.out.println(ans);
        
        
    }

    static void dfs(int depth,int x,int y) {
        
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        ans = Math.max(ans,depth);
        for (int i = 0; i < 4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            char c = map[nx][ny];
            if (alpha[c - 'A']) continue;
            alpha[c - 'A'] = true;
            dfs(depth + 1, nx , ny);
            alpha[c - 'A'] = false;
        }
        
    }

    
}