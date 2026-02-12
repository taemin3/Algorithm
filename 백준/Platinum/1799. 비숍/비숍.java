import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [][] map;
    static int n;
    static boolean [] check1;
    static boolean [] check2;
    static int max1 = 0;
    static int max2 = 0;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0;i < n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check1 = new boolean[n * 2];
        check2 = new boolean[n * 2];
        dfs(0,0,0);
        dfs(0,1,0);

        System.out.println(max1 + max2);
        
        
    }

    static void dfs(int x,int y, int cnt) {

        if (y >= n) {
            x++;
            y = (y % 2 == 0) ? 1 : 0;
        } 
        if (x >= n) {
            if (y % 2 == 0) {
                max1 = Math.max(max1,cnt);
            } else {
                max2 = Math.max(max2,cnt);
            }
            return;
        }

        if (map[x][y] == 1 && !check1[x - y + n] && !check2[x + y]) {
            check1[x - y + n] = true;
            check2[x + y] = true;

            dfs(x, y + 2, cnt + 1);

            check1[x - y + n] = false;
            check2[x + y] = false;
        } 
        dfs(x, y + 2, cnt);
    }
}