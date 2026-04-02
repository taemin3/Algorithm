import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static char [][] map;
    static boolean [][] visit;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        visit = new boolean[5][5];
        for (int i = 0; i < 5;i++) {
            String str = br.readLine();
            for (int j = 0; j < 5;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        back(0,0,0);
        System.out.println(ans);
    }

    public static void back(int idx, int cnt, int depth) {
        if (cnt >= 4) {
            return;
        }

        if (depth == 7) {
            if (check((idx -1) /5,(idx - 1) %5)){
                ans++;
            }
            return;
        }
        
        for (int i = idx; i < 25;i++) {
            int x = i / 5;
            int y = i % 5;
            visit[x][y] = true;
            if (map[x][y] == 'Y') {
                back(i + 1, cnt + 1,depth + 1);
            } else {
                back(i + 1, cnt,depth + 1);
            }
            visit[x][y] = false;
        }
    }

    public static boolean check(int x,int y) {
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        boolean [][] visit2 = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visit2[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
           

            for (int i = 0 ; i < 4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visit2[nx][ny]) continue;
                if (!visit[nx][ny]) continue;
                cnt++;
                visit2[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
            
        }
        if (cnt == 7) {
            return true;
            
        }
        return false;
    }

}