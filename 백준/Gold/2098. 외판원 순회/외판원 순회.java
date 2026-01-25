import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static int[][] map;
    static int N;
    static int FULL;
    static final int INF = 10_000_000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        FULL = 1 << N;

        map = new int[N][N];
        dp = new int[N][FULL];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int x, int visit) {
        if (visit == FULL - 1) {
            if (map[x][0] == 0) return INF;
            return map[x][0];
        }

       
        if (dp[x][visit] != -1) return dp[x][visit];
        dp[x][visit] = INF;

        for (int i = 0; i < N; i++) {
            if (map[x][i] == 0) continue;
            if ((visit & (1 << i)) != 0) continue; 

            int next = visit | (1 << i);
            dp[x][visit] = Math.min(dp[x][visit], tsp(i, next) + map[x][i]);
        }
        return dp[x][visit];
    }
}