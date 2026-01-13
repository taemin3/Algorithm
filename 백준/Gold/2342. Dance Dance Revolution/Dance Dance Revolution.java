import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (true) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) break;
            list.add(a);
        }

        int n = list.size();
        int [][][] dp = new int[n+1][5][5];
        int INF = 100000000;
        for (int i = 0; i <= n;i++) {
            for (int j = 0;j <5;j++) {
                Arrays.fill(dp[i][j],INF);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0;i < n;i++){
            int x = list.get(i);
            for (int l = 0; l < 5;l++) {
                for (int r = 0; r < 5; r++) {
                    int cur = dp[i][l][r];
                    if (cur == INF) continue;

                    dp[i+1][x][r] = Math.min(dp[i+1][x][r], cur + cost(l,x));
                    dp[i+1][l][x] = Math.min(dp[i+1][l][x], cur + cost(r,x));
                }
            }
        }
        int ans = INF;
        for (int l = 0; l < 5;l++) {
                for (int r = 0; r < 5; r++) {
                    ans = Math.min(dp[n][l][r],ans);
                }
            }
        System.out.println(ans);
    }

    public static int cost (int a,int b) {
        if (a == b) return 1;
        if (a == 0) return 2;
        if (Math.abs(a - b) == 2) return 4;
        return 3;
        
    }

    
}