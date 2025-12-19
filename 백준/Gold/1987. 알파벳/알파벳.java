import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static char [][] map;
    static boolean [] visit;
    static int r, c;
    static int max = 0;
    static Set<Character> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        set = new HashSet<>();

        map = new char[r][c];
        visit = new boolean[26];

        for (int i =0; i < r;i++) {
            String str = br.readLine();
            for (int j = 0; j < c;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visit[map[0][0] - 'A'] = true;
        bfs(0,0,1);
        System.out.println(max);
    }

    public static void bfs(int x , int y, int w) {
        
        if (w > max) {
            max = w;
        }
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
       
        
            for (int i = 0;i < 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (visit[map[nx][ny] - 'A']) continue;
                visit[map[nx][ny] - 'A'] = true;
                bfs(nx,ny,w + 1);
                visit[map[nx][ny] - 'A'] = false;
            
            }
        
    }
}